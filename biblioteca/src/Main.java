package biblioteca.src;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Inserir dois livros
            Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899);
            Livro livro2 = new Livro("1984", "George Orwell", 1949);

            dao.inserir(livro1);
            dao.inserir(livro2);
            System.out.println("Livros inseridos com sucesso!\n");

            // 2. Listar todos os livros
            System.out.println("--- Lista de Livros ---");
            List<Livro> livros = dao.listar();
            for (Livro l : livros) {
                System.out.println(l);
            }

            // 3. Buscar por título
            System.out.print("\nDigite um título para buscar: ");
            String tituloBusca = scanner.nextLine();
            List<Livro> encontrados = dao.buscarPorTitulo(tituloBusca);
            System.out.println("Resultados da busca:");
            for (Livro l : encontrados) {
                System.out.println(l);
            }

            // 4. Remover um livro por ID
            System.out.print("\nDigite um ID para remover: ");
            int idRemover = scanner.nextInt();
            scanner.nextLine();
            if (dao.remover(idRemover)) {
                System.out.println("Livro removido.");
            } else {
                System.out.println("ID não encontrado.");
            }

            // 5. Atualizar um livro
            System.out.print("\nDigite o ID do livro que deseja atualizar: ");
            int idAtualizar = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Novo título: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Novo autor: ");
            String novoAutor = scanner.nextLine();
            System.out.print("Novo ano: ");
            int novoAno = scanner.nextInt();

            Livro livroAtualizado = new Livro(novoTitulo, novoAutor, novoAno);
            livroAtualizado.setId(idAtualizar);
            if (dao.atualizar(livroAtualizado)) {
                System.out.println("Livro atualizado.");
            } else {
                System.out.println("ID não encontrado.");
            }

            // Listar novamente para ver as alterações
            System.out.println("\n--- Lista atualizada ---");
            livros = dao.listar();
            for (Livro l : livros) {
                System.out.println(l);
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}