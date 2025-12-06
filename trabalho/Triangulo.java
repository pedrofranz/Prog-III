public class Triangulo extends Forma {
        
    private double altura;
    private double base;

    public Triangulo(double base, double altura){
        if (base <= 0 && altura <= 0) {
            throw new IllegalArgumentException("A base e a Altura devem ser maior que zero.");
        }
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calculaArea() {
        double result = base * altura;
        return result / 2;
    }
}