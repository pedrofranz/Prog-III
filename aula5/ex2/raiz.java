package ex2;

public class raiz {

    public static double calculaRaiz(double numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("Não é possível calcular a raiz de número negativo.");
        }
        return Math.sqrt(numero);
    }

    public static void main(String[] args) {
        
        try {
            int numero = -9;
            double resultado = calculaRaiz(numero);
            System.out.println("Raiz quadrada: " + resultado);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
