package Conta;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(double saldo) {
        super(saldo);
    }

    @Override
    public boolean Sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            this.saldo = saldo - 1;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void Deposiar(double valor) {
        this.saldo += valor;
    }
}
