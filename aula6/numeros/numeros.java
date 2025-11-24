import java.util.ArrayList;
import java.util.Scanner;

public class numeros {
    public static void main(String[] args) {
        int soma = 0;
        double media = 0;
        int n;
        Scanner ler = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            n = ler.nextInt();
            numeros.add(n);
        }

        System.out.println(numeros);

        for (Integer numero : numeros) {
            soma += numero;
        }

        System.out.println(soma);
        media = soma/10;
        System.out.println(media);

        numeros.removeIf(numero -> numero % 2 == 0);

        System.out.println(numeros);

        ler.close();

        }
}
