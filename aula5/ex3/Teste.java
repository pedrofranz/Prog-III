package ex3;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Digite um número inteiro:");
            String entrada = sc.nextLine();
            int numero = Integer.parseInt(entrada);
            
            System.out.println("Número digitado: " + numero);

        } catch (NumberFormatException e) {
            System.out.println("Erro: você digitou um valor que não é um número inteiro.");
        } finally {
            System.out.println("Encerrando programa...");
            sc.close();
        }
    }
}
