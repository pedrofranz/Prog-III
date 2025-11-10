package Conta;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(double saldo) {
            super(saldo);
    }

    @Override
    public boolean Sacar(double valor) {
        if(this.getSaldo() >= valor) {
            this.saldo -= valor;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void Deposiar(double valor){
        this.saldo += valor;
    }

}
