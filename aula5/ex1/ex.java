package ex1;

import java.util.Scanner;

public class ex {
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);

        int numero1, numero2;
        int result = 0;

        numero1 = ler.nextInt();
        numero2 = ler.nextInt();

        try {
            result = numero1 / numero2;
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Erro: divisão por zero não é permitida.");
        }

        ler.close();
    }
}
