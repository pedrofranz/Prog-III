package contaBancaria;

public class ContaBancaria {
    private int numero;

    @Override
    public String toString() {
        return "ContaBancaria {Número da conta = " + this.numero + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return false;
        }
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria();
        ContaBancaria c2 = new ContaBancaria();
        c1.setNumero(10);
        c2.setNumero(23);

        System.out.println("c1.equals(c2): " + c1.equals(c2));
        System.out.println("c1.toString(): " + c1.toString());
        System.out.println("c2.toString(): " + c2.toString());
    }
}
