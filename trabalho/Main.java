import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Modo Console");
            System.out.println("2 - Modo Gráfico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    menuConsole(ler);
                    break;
                case 2:
                    System.out.println("Abrindo interface gráfica...");
                    InterfaceGrafica.main(args);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    ler.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void menuConsole(Scanner ler) {
        while (true) {
            System.out.println("\n===== MENU CONSOLE =====");
            System.out.println("1 - Calcular área de UMA forma (modo interativo)");
            System.out.println("2 - Calcular soma das áreas (modo automático)");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            int opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    calcularFormaIndividual(ler);
                    break;
                case 2:
                    calcularSomaAreas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void calcularFormaIndividual(Scanner ler) {
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

        int tipo = ler.nextInt();
        Forma f = null;

        try {
            switch (tipo) {
                case 1:
                    System.out.print("Raio: ");
                    f = new Circulo(ler.nextDouble());
                    break;
                case 2:
                    System.out.print("Lado: ");
                    f = new Quadrado(ler.nextDouble());
                    break;
                case 3:
                    System.out.print("Base: ");
                    double b = ler.nextDouble();
                    System.out.print("Altura: ");
                    double a = ler.nextDouble();
                    f = new Retangulo(b, a);
                    break;
                case 4:
                    System.out.print("Base: ");
                    b = ler.nextDouble();
                    System.out.print("Altura: ");
                    a = ler.nextDouble();
                    f = new Triangulo(b, a);
                    break;
                case 5:
                    System.out.print("Diagonal Maior: ");
                    double d_maior = ler.nextDouble();
                    System.out.print("Diagonal Menor: ");
                    double d_menor = ler.nextDouble();
                    f = new Losango(d_maior, d_menor);
                    break;
                case 6:
                    System.out.print("Dimensões: ");
                    int dimensoes = ler.nextInt();
                    System.out.print("Aresta: ");
                    double aresta = ler.nextDouble();
                    f = new Hipercubo(dimensoes, aresta);
                    break;
                case 7:
                    System.out.print("Curvatura: ");
                    double curvatura = ler.nextDouble();
                    System.out.print("Raio máximo: ");
                    double raio_max = ler.nextDouble();
                    f = new Paraboloide(curvatura, raio_max);
                    break;
                case 8:
                    System.out.print("Base maior: ");
                    double Bmaior = ler.nextDouble();
                    System.out.print("Base menor: ");
                    double Bmenor = ler.nextDouble();
                    System.out.print("Altura: ");
                    double altura = ler.nextDouble();
                    f = new Trapezio(Bmaior, Bmenor, altura);
                    break;
                default:
                    System.out.println("Forma inválida!");
                    return;
            }
            System.out.println("Área calculada: " + f.calculaArea());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void calcularSomaAreas() {
        ArrayList<Forma> formas = new ArrayList<>();

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
        System.out.println("Soma total das áreas: " + soma);
    }
}