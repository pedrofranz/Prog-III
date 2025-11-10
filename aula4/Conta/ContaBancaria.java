package Conta;

public abstract class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean Sacar(double valor);
    public abstract void Deposiar(double valor);
}
