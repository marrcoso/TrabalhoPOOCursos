package trabalhopoo;

import java.util.ArrayList;

public class CursoOnline extends Curso {
    private String localDeAula;
    private String linkDeAcesso;
    Curso curso;
    Aluno aluno;

    public CursoOnline(String nome, int cargaHoraria, String professor, String localDeAula, String linkDeAcesso) {
        super(nome, cargaHoraria, professor);
        ArrayList<Aluno> alunos = new ArrayList();
        this.localDeAula = localDeAula;
        this.linkDeAcesso = linkDeAcesso;
        this.curso = curso;
    }

    public String calcularDuracao() {
        int duracao = curso.getCargaHoraria()*5;
        return duracao + "horas na semana.";
    }

    public String emitirCertificado() {
        return "CERTIFICO QUE O CURSO ONLINE " + curso.getNome() + " FEITO POR " + aluno.getNome() + " FOI CONCLUÍDO COM UM TOTAL DE: "
                + "\n" + calcularDuracao() + " HORAS SEMANAIS.";
    }
}
