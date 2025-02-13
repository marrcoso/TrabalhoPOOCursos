package trabalhopoo;

public class Aluno {
    private Long matricula;
    private String nome;

    public Aluno() {}

    public Aluno(Long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "(" + matricula + ", " + nome + ")";
    }
}
