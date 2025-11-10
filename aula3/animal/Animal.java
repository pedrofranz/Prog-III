package animal;

import java.util.ArrayList;

public class Animal {
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public Animal(String var1) {
        this.nome = var1;
    }

    public void emitirSom() {
        System.out.println("Um som de um animalzinho");
    }

    public static class Cao extends Animal{

        @Override
        public void emitirSom() {
            System.out.println("AUAUAUUAUAUUA");
            super.emitirSom();
        }

        public Cao(String var1) {
            super(var1);
        }

        @Override
        public String getNome() {
            return super.getNome();
        }

        @Override
        public void setNome(String nome) {
            super.setNome(nome);
        }
    }

    public static class Gato extends Animal {

        @Override
        public void emitirSom() {
            System.out.println("MIAUUUUUUU");
            super.emitirSom();

        }
        public Gato(String var1) {
            super(var1);
        }

        @Override
        public String getNome() {
            return super.getNome();
        }

        @Override
        public void setNome(String nome) {
            super.setNome(nome);
        }
    }

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();

        Gato a = new Gato("farofa");
        Cao b = new Cao("mingau");

        animals.add(a);
        animals.add(b);

        for(Animal animal : animals) {
            animal.emitirSom();
        }
    }
}
