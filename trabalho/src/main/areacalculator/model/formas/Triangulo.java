package areacalculator.model.formas;

public class Triangulo extends Forma {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser maiores que zero.");
        }
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return (base * altura) / 2;
    }
}