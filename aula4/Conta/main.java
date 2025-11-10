package Conta;

public class main {
    public static void main(String[] args) {
        ContaPoupanca c1 = new ContaPoupanca(0.0);
        ContaCorrente c = new ContaCorrente(0.0);



        c1.Deposiar(100.0);
        c.Deposiar(1000.0);

        System.out.println(c1.getSaldo());
        System.out.println(c.getSaldo());

        c1.Sacar(99.0);
        c.Sacar(999.0);

        System.out.println(c1.getSaldo());
        System.out.println(c.getSaldo());
    }
}
