import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            PrintStream ps = new PrintStream("saida.txt");

            System.out.println("Digite várias linhas (digite FIM para encerrar):");

            while (true) {
                String linha = sc.nextLine();

                if (linha.equalsIgnoreCase("FIM")) {
                    break;
                }

                ps.println(linha);
            }

            ps.close();
            System.out.println("Arquivo 'saida.txt' gravado com sucesso!");

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }

        sc.close();
    }
}
