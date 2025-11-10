package Pessoa;

import Pessoa.Nivel.NivelAcesso;

public class main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Calors", NivelAcesso.BASICO);
        Pessoa p2 = new Pessoa("Joserlindo da Silva alves campos", NivelAcesso.INTERMEDIARIO);
        Pessoa p3 = new Pessoa("Laurinha Mata Rindo", NivelAcesso.ADMIN);

        System.out.println("O " + p1.getNome() + " e uma pessoa normie, Nível de acesso: " + p1.getNivelAcesso());
        System.out.println("O " + p2.getNome() + " e uma pessoa melhorzinha, Nível de acesso: " + p2.getNivelAcesso());
        System.out.println("O " + p3.getNome() + " e uma pessoa top demais, Nivel de acesso: " + p3.getNivelAcesso());

    }
}
