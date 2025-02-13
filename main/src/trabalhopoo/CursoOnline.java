package trabalhopoo;

import java.util.ArrayList;

public class CursoOnline extends Curso {
    private String localDeAula;
    private String linkDeAcesso;
    Aluno aluno;

    public CursoOnline(String nome, int cargaHoraria, String professor, String localDeAula, String linkDeAcesso) {
        super(nome, cargaHoraria, professor);
        this.localDeAula = localDeAula;
        this.linkDeAcesso = linkDeAcesso;
    }

    private int calcularDuracao() {
        int duracao = this.getCargaHoraria()*5;
        return duracao;
    }

    @Override
    public void emitirCertificado(Aluno aluno) {
        System.out.println("CERTIFICO QUE O CURSO ONLINE DE " + this.getNome() + " FEITO POR " + aluno.getNome() + " FOI CONCLUÍDO COM UM TOTAL DE: "
                + "\n" + calcularDuracao() + " HORAS SEMANAIS.");
    }
}
