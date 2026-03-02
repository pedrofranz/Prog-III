package areacalculator.controller;

import areacalculator.model.formas.*;
import areacalculator.view.InterfaceGrafica;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Aplica o look and feel Nimbus para a interface gráfica (se disponível)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Ignora e usa o look and feel padrão
        }

        while (true) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    menuConsole();
                    break;
                case 2:
                    System.out.println("Abrindo interface gráfica...");
                    scanner.close();
                    InterfaceGrafica.main(args);
                    return; // Encerra o console após abrir a janela
                case 0:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1 - Modo Console");
        System.out.println("2 - Modo Gráfico");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next(); // Descarta a entrada inválida
            return -1;      // Retorna opção inválida
        }
    }

    private static void menuConsole() {
        while (true) {
            System.out.println("\n===== MENU CONSOLE =====");
            System.out.println("1 - Calcular área de UMA forma (modo interativo)");
            System.out.println("2 - Calcular soma das áreas (modo automático)");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    calcularFormaIndividual();
                    break;
                case 2:
                    calcularSomaAreas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void calcularFormaIndividual() {
        System.out.println("\nEscolha a forma:");
        System.out.println("1 - Círculo");
        System.out.println("2 - Quadrado");
        System.out.println("3 - Retângulo");
        System.out.println("4 - Triângulo");
        System.out.println("5 - Losango");
        System.out.println("6 - Hipercubo");
        System.out.println("7 - Paraboloide");
        System.out.println("8 - Trapézio");
        System.out.print("Opção: ");

        int tipo = lerOpcao();
        Forma forma = null;

        try {
            switch (tipo) {
                case 1: // Círculo
                    System.out.print("Raio: ");
                    double raio = lerDouble();
                    forma = new Circulo(raio);
                    break;
                case 2: // Quadrado
                    System.out.print("Lado: ");
                    double lado = lerDouble();
                    forma = new Quadrado(lado);
                    break;
                case 3: // Retângulo
                    System.out.print("Base: ");
                    double base = lerDouble();
                    System.out.print("Altura: ");
                    double altura = lerDouble();
                    forma = new Retangulo(base, altura);
                    break;
                case 4: // Triângulo
                    System.out.print("Base: ");
                    base = lerDouble();
                    System.out.print("Altura: ");
                    altura = lerDouble();
                    forma = new Triangulo(base, altura);
                    break;
                case 5: // Losango
                    System.out.print("Diagonal Maior: ");
                    double dMaior = lerDouble();
                    System.out.print("Diagonal Menor: ");
                    double dMenor = lerDouble();
                    forma = new Losango(dMaior, dMenor);
                    break;
                case 6: // Hipercubo
                    System.out.print("Dimensões (inteiro): ");
                    int dimensoes = lerInteiro();
                    System.out.print("Aresta: ");
                    double aresta = lerDouble();
                    forma = new Hipercubo(dimensoes, aresta);
                    break;
                case 7: // Paraboloide
                    System.out.print("Curvatura: ");
                    double curvatura = lerDouble();
                    System.out.print("Raio máximo: ");
                    double raioMax = lerDouble();
                    forma = new Paraboloide(curvatura, raioMax);
                    break;
                case 8: // Trapézio
                    System.out.print("Base maior: ");
                    double baseMaior = lerDouble();
                    System.out.print("Base menor: ");
                    double baseMenor = lerDouble();
                    System.out.print("Altura: ");
                    altura = lerDouble();
                    forma = new Trapezio(baseMaior, baseMenor, altura);
                    break;
                default:
                    System.out.println("Forma inválida!");
                    return;
            }

            if (forma != null) {
                System.out.printf("Área calculada: %.2f%n", forma.calculaArea());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro: entrada inválida. Digite números.");
            scanner.next(); // Limpa o buffer
        }
    }

    /**
     * Lê um valor double do usuário, tratando entradas inválidas.
     */
    private static double lerDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Valor inválido. Digite um número: ");
                scanner.next(); // Descarta a entrada incorreta
            }
        }
    }

    /**
     * Lê um valor inteiro do usuário, tratando entradas inválidas.
     */
    private static int lerInteiro() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Valor inválido. Digite um número inteiro: ");
                scanner.next(); // Descarta a entrada incorreta
            }
        }
    }

    private static void calcularSomaAreas() {
        List<Forma> formas = new ArrayList<>();
        formas.add(new Circulo(3));
        formas.add(new Quadrado(4));
        formas.add(new Retangulo(3, 6));
        formas.add(new Triangulo(5, 2));
        formas.add(new Losango(6, 4));
        formas.add(new Hipercubo(4, 2));
        formas.add(new Paraboloide(0.5, 3));
        formas.add(new Trapezio(10, 6, 4));

        double soma = 0;
        for (Forma f : formas) {
            soma += f.calculaArea();
        }
        System.out.printf("Soma total das áreas: %.2f%n", soma);
    }
}