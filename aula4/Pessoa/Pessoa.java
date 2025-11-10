package Pessoa;

import Pessoa.Nivel.NivelAcesso;

public class Pessoa {
    protected String nome;
    protected NivelAcesso nivelAcesso;

    public Pessoa(String nome, NivelAcesso nivelAcesso) {
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }
    public String getNome() {
        return nome;
    }
    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
