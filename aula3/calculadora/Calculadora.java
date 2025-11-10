package calculadora;

public class Calculadora {

    public void somar(int var1, int var2) {
        int result = var1 + var2;
        System.out.println("Resultado da soma: "+ result);
    }

    public void somar(double var1, double var2) {
        double result = var1 + var2;
        System.out.println("Resultado da soma: " + result);
    }

    void somar(int var1, int var2, int var3) {
        int result = var1 + var2 + var3;
        System.out.println("Resultado da soma dos 3 números: " + result);
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        c.somar(1, 1);
        c.somar(1.1, 886060867078.1);
        c.somar(1, 2, 3);
    }
}