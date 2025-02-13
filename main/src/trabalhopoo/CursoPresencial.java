package trabalhopoo;

import java.util.ArrayList;

public class CursoPresencial extends Curso {
    private String localDeAula;
    private String linkDeAcesso;
    Curso curso;
    Aluno aluno;

    public CursoPresencial(String nome, int cargaHoraria, String professor, String localDeAula, String linkDeAcesso) {
        super(nome, cargaHoraria, professor);
        this.localDeAula = localDeAula;
        this.linkDeAcesso = linkDeAcesso;
    }

    public String calcularDuracao() {
        int duracao = curso.getCargaHoraria()*5;
        return duracao + "horas na semana.";
    }

    public String emitirCertificado() {
        return "CERTIFICO QUE O CURSO " + curso.getNome() + " PRESENCIAL FEITO POR " + aluno.getNome() + " FOI CONCLUÍDO COM UM TOTAL DE: "
                + "\n" + calcularDuracao() + " HORAS SEMANAIS.";
    }
}
