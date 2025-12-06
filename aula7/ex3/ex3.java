import java.io.File;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo ou diretório: ");
        String caminho = sc.nextLine();

        File f = new File(caminho);

        if (!f.exists()) {
            System.out.println("O caminho informado não existe.");
        } else {
            if (f.isFile()) {
                System.out.println("É um arquivo.");
            } else if (f.isDirectory()) {
                System.out.println("É um diretório.");
            }

            System.out.println("Tamanho: " + f.length() + " bytes");

            System.out.println("Caminho absoluto: " + f.getAbsolutePath());

            if (f.isDirectory()) {
                System.out.println("\nArquivos dentro do diretório:");
                File[] lista = f.listFiles();

                if (lista != null) {
                    for (File arq : lista) {
                        System.out.println("- " + arq.getName());
                    }
                }
            }
        }

        sc.close();
    }
}
