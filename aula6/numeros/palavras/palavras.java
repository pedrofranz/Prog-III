import java.util.HashSet;
import java.util.Scanner;

public class palavras {
    public static void main(String[] args) {
        
        HashSet<String> palavras = new HashSet<String>();
        String str;

        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.print("Digite uma palavra (ou 'fim' para terminar): ");
            str = ler.nextLine();
            
            if (str.equals("fim")) {
                break;
            } else {
                palavras.add(str);
            }
        }

        System.out.println("O conjunto contém 'java': " + palavras.contains("java")); 
        System.out.println("Palavras digitadas: " + palavras);
        
        ler.close();
    }
}