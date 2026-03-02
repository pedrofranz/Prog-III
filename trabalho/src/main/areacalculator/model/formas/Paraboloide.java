package areacalculator.model.formas;

public class Paraboloide extends Forma {
    private double curvatura;
    private double raioMax;

    public Paraboloide(double curvatura, double raioMax) {
        if (Math.abs(curvatura) < 1e-12) {
            throw new IllegalArgumentException("A curvatura não pode ser zero.");
        }
        if (raioMax <= 0) {
            throw new IllegalArgumentException("O raio deve ser maior que zero.");
        }
        this.curvatura = curvatura;
        this.raioMax = raioMax;
    }

    @Override
    public double calculaArea() {
        double a = curvatura;
        double r = raioMax;

        double termo1 = Math.PI * r * r * Math.sqrt(1 + 4 * a * a * r * r);
        double termo2 = (Math.PI / (4 * a)) * 
                        Math.log(2 * a * r + Math.sqrt(1 + 4 * a * a * r * r));
        return termo1 + termo2;
    }
}