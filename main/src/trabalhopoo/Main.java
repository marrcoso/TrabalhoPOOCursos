package trabalhopoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int escolha = 0;
        String nome;
        String nomeCurso;
        int cargaHoraria;
        String professor;
        String localDeAula;
        String linkDeAcesso;
        String modalidade;
        Long matricula;
        boolean encontrado = true;
        List<Curso> cursos = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        List<Aluno> alunosDisponiveis = new ArrayList<>();


//        cursos.add(new CursoPresencial("ADS", 4, "Fernando", "IFSC", "ifsc.com.br"));
//        cursos.add(new CursoPresencial("EMBARCADOS", 4, "Fernando", "IFSC", "ifsc.com.br"));

        while (escolha != 9) {
            System.out.println("Menu"
            + "\n1 - Cadastrar Curso"
            + "\n2 - Cadastrar Aluno"
            + "\n3 - Matricular Aluno em um curso"
            + "\n4 - Cancelar Matricula em um curso"
            + "\n9 - Sair");

            escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("Digite o nome do Curso: ");
                nomeCurso = sc1.nextLine();
                System.out.println("Digite a carga horária (horas p/ dia): ");
                cargaHoraria = sc.nextInt();
                System.out.println("Digite o nome do Professor: ");
                professor = sc1.nextLine();
                System.out.println("Digite o local de aula: ");
                localDeAula = sc1.nextLine();
                System.out.println("Digite o link de acesso: ");
                linkDeAcesso = sc1.nextLine();
                System.out.println("Digite a modalidade do Curso: ");
                modalidade = sc1.nextLine();
                Curso curso;
                if (modalidade.equalsIgnoreCase("presencial")) {
                    curso = new CursoPresencial(nomeCurso, cargaHoraria, professor, localDeAula, linkDeAcesso);
                } else if (modalidade.equalsIgnoreCase("online")) {
                    curso = new CursoOnline(nomeCurso, cargaHoraria, professor, localDeAula, linkDeAcesso);
                } else {
                    throw new RuntimeException("Modalidade não suportada!");
                }
                cursos.add(curso);
            }
            if (escolha == 2) {
                System.out.println("Digite o nome do aluno: ");
                nome = sc1.nextLine();
                Random random = new Random();
                matricula = random.nextLong(100000, 999999);
                while (encontrado) {
                    Long matriculaEncontrada = null;
                    for (Aluno it : alunos) {
                        if (it.getMatricula().equals(matricula)) {
                            matriculaEncontrada = it.getMatricula();
                            matricula = random.nextLong(100000, 999999);
                            break;
                        }
                    }
                    if (matriculaEncontrada == null) {
                        encontrado = false;
                    }
                }
                Aluno aluno = new Aluno(matricula, nome);
                alunos.add(aluno);
                System.out.println("Aluno " + aluno + " cadastrado com sucesso!");

            }
            if (escolha == 3) {
                System.out.println("Digite o nome do curso: ");
                nomeCurso = sc1.nextLine();

                Curso cursoEncontrado = null;
                for (Curso it : cursos) {
                    if (it.getNome().equalsIgnoreCase(nomeCurso)) {
                        cursoEncontrado = it;
                        break;
                    }
                }

                if (cursoEncontrado == null) {
                    System.out.println("Curso não encontrado.");
                    continue;
                }

                System.out.println("Alunos no sistema que não estão cadastrados neste curso:");

                for (Aluno it : alunos) {
                    if (!cursoEncontrado.getMatriculados().contains(it)) {
                        alunosDisponiveis.add(it);
                        System.out.println(it);
                    }
                }
                if (alunosDisponiveis.isEmpty()) {
                    throw new RuntimeException("Não existem alunos cadastrados no sistema para cadastrar neste curso.");
                }

                System.out.println("Digite a matrícula do aluno para matricular no curso " + nomeCurso + ": ");
                try {
                    matricula = Long.parseLong(sc1.nextLine());
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("A matrícula deve conter somente números!");
                }
                Aluno alunoEncontrado = null;
                for (Aluno it : alunos) {
                    if (it.getMatricula().equals(matricula)) {
                        alunoEncontrado = it;
                        break;
                    }
                }

                if (alunoEncontrado == null) {
                    System.out.println("Matrícula não encontrada.");
                } else {
                    cursoEncontrado.matricularAluno(alunoEncontrado);
                }
            }
            if (escolha == 4) {
                if (cursos.isEmpty()){
                    throw new RuntimeException("Nenhum curso cadastrado no sistema.");
                }
                System.out.println("Digite o curso a ser selecionado: ");
                nomeCurso = sc1.nextLine();

                Curso cursoEncontrado = null;
                for (Curso it : cursos) {
                    if (it.getNome().equalsIgnoreCase(nomeCurso)) {
                        cursoEncontrado = it;
                        break;
                    }
                }

                if (cursoEncontrado == null) {
                    System.out.println("Curso não encontrado.");
                } else {
                    Aluno alunoEncontrado = null;
                    for (Aluno it : alunosDisponiveis) {
                        if (cursoEncontrado.getMatriculados().contains(it)) {
                            alunoEncontrado = it;
                            System.out.println(it);
                        }
                    }

                    if (alunoEncontrado == null) {
                        throw new RuntimeException("Não existem alunos cadastrados no curso de " + cursoEncontrado.getNome() + " para remover.");
                    }

                    if (alunosDisponiveis.isEmpty()) {
                        throw new RuntimeException("Não existem alunos cadastrados no sistema para remover do curso de " + cursoEncontrado.getNome() + ".");
                    }
                    System.out.println("Digite a matricula do aluno a ser cancelado neste curso: ");
                    try {
                        matricula = Long.parseLong(sc1.nextLine());
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("A matrícula deve conter somente números!");
                    }

                    alunoEncontrado = null;
                    for (Aluno it : cursoEncontrado.getMatriculados()) {
                        if (it.getMatricula().equals(matricula)) {
                            alunoEncontrado = it;
                            break;
                        }
                    }

                    if (alunoEncontrado == null) {
                        System.out.println("Aluno não encontrado no curso de " + nomeCurso + ".");
                    } else {
                        cursoEncontrado.cancelarMatricula(alunoEncontrado);
                    }
                }
            }
        }
    }
}
