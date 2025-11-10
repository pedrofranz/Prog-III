package pessoaMod;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String var1, int var2) {
        this.nome = var1;
        this.idade = var2;
    }

    public static class Aluno extends Pessoa {
    private boolean matriculado;

    public Aluno(String var1, int var2, boolean var3) {
        super(var1, var2);
        this.matriculado = var3;
    }

    public boolean getMatricula() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }
}
    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Xitãozinho", 45, true);
        System.out.println("Nome do aluno: " + a1.getNome() + " Idade: " + a1.getIdade() + " Situação: " + a1.getMatricula());


        Aluno a2 = new Aluno("nada", 0, false);


        a2.setNome("Miguelzinho do capa");
        a2.setIdade(13);
        a2.setMatriculado(true);

        System.out.println("Nome do aluno: " + a2.getNome() + " Idade: " + a2.getIdade() + " Situação: " + a2.getMatricula());

    }
}

