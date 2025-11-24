import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pessoa {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Map<String, Integer> example = new HashMap<>();

        System.out.println("Digite o nome da pessoa e a idade (ou 'sair' para fechar)");

        while (true) {
            System.out.println("Nome:");
            String nome = ler.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Idade:");
            String idadeStr = ler.nextLine().trim();
            int idade = Integer.parseInt(idadeStr);

            example.put(nome, idade);
        }

        System.out.println("Informe um nome para verificar a idade:");
        String nomeBusca = ler.nextLine().trim();

        if (example.containsKey(nomeBusca)) {
            System.out.println("A idade de " + nomeBusca + " é: " + example.get(nomeBusca));
        } else {
            System.out.println("Nome não encontrado!");
        }

        System.out.println("Informe um nome para remoção:");
        String nomeRemover = ler.nextLine().trim();

        if (example.remove(nomeRemover) != null) {
            System.out.println(nomeRemover + " removido com sucesso!");
        } else {
            System.out.println("Nome não encontrado para remoção!");
        }

        System.out.println(example);

        ler.close();
    }
}
