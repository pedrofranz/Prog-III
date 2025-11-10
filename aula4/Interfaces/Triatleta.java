package Interfaces;

public class Triatleta implements Ciclista, Nadador, Corredor {
    private String nome;

    public Triatleta(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void Pedalar() {
        System.out.println("O atleta " + getNome() + " iniciou sua fase de pedalar");
    }

    @Override
    public void Nadar() {
        System.out.println("O atleta " + getNome() + " está nadando");
    }

    @Override
    public void Correr() {
        System.out.println("Agora o atleta " + getNome() + " está correndo");
    }
}
