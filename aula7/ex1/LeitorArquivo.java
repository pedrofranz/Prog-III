import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LeitorArquivo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo (com extensão): ");
        String nomeArquivo = sc.nextLine();

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            fis = new FileInputStream(nomeArquivo);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            String linha;
            System.out.println("\n=== Conteúdo do arquivo ===\n");
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (isr != null) isr.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar os streams: " + e.getMessage());
            }

            System.out.println("\nEncerrando programa...");
        }

        sc.close();
    }
}
