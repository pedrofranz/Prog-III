package ProgIII.aula2.contador;

class Contador {

    public Contador() {
        qtd++;
    }

    public static int qtd;

    public static void mostrarTotal() {
        System.out.println("Quantidade de objetos criados na execução do programa:" + qtd);
    }
    public static void main(String[] args) {
        Contador c = new Contador();
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();
        Contador c4 = new Contador();
        Contador c5 = new Contador();
        Contador c6 = new Contador();
        Contador c7 = new Contador();
        Contador c8 = new Contador();
        Contador c9 = new Contador();
        mostrarTotal();   
    }
}

