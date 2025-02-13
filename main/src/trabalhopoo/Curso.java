package trabalhopoo;

import java.util.ArrayList;
import java.util.List;

public class Curso implements Inscricao{
    private String nome;
    private int cargaHoraria;
    private String professor;
    private List<Aluno> matriculados;

    public Curso() {
    }

    public Curso(String nome, int cargaHoraria, String professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.matriculados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getProfessor() {
        return professor;
    }

    public List<Aluno> getMatriculados() {
        return matriculados;
    }

    public void emitirCertificado(Aluno aluno){};

    @Override
    public void matricularAluno(Aluno aluno) {
        if (matriculados.contains(aluno)) {
            throw new RuntimeException("Aluno já matriculado!");
        }
        matriculados.add(aluno);
        System.out.println("O Aluno " + aluno.getNome() + " foi matriculado com sucesso!");
    }

    @Override
    public void cancelarMatricula(Aluno aluno) {
        if (!matriculados.contains(aluno)) {
            throw new RuntimeException("Aluno não encontrado!");
        }
        matriculados.remove(aluno);
        System.out.println("O Aluno " + aluno.getNome() + " foi removido com sucesso!");
    }
}
