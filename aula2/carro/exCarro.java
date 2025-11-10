class Carro {
    String marca;
    String modelo;
    int ano;

    public void exibirInfo() {
        System.out.println("Marca do Carro: " + this.marca);
        System.out.println("Modelo do Carro: " + this.modelo);
        System.out.println("Ano do Carro: " + this.ano);
    }
}

public class exCarro {
    public static void main(String[] args) {
        Carro crr = new Carro();
        Carro crr2 = new Carro();

        crr.ano = 2022;
        crr.marca = "Fiat";
        crr.modelo = "Uno";

        crr2.ano = 1979;
        crr2.marca = "General Dynamics Land Systems";
        crr2.modelo = "Leopard 2";

        crr.exibirInfo();
        crr2.exibirInfo();
    }
}
