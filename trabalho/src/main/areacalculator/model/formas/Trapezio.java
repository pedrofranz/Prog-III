package areacalculator.model.formas;

public class Trapezio extends Forma {
    private double baseMaior;
    private double baseMenor;
    private double altura;

    public Trapezio(double baseMaior, double baseMenor, double altura) {
        if (baseMaior <= 0 || baseMenor <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Todas as medidas devem ser maiores que zero.");
        }
        if (baseMaior <= baseMenor) {
            throw new IllegalArgumentException("A base maior deve ser maior que a base menor.");
        }
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return ((baseMaior + baseMenor) * altura) / 2;
    }
}