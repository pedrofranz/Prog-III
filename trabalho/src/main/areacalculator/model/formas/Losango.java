package areacalculator.model.formas;

public class Losango extends Forma {
    private double diagonalMaior;
    private double diagonalMenor;

    public Losango(double diagonalMaior, double diagonalMenor) {
        if (diagonalMaior <= 0 || diagonalMenor <= 0) {
            throw new IllegalArgumentException("As diagonais devem ser maiores que zero.");
        }
        if (diagonalMaior <= diagonalMenor) {
            throw new IllegalArgumentException("A diagonal maior deve ser maior que a diagonal menor.");
        }
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
    }

    @Override
    public double calculaArea() {
        return (diagonalMaior * diagonalMenor) / 2;
    }
}