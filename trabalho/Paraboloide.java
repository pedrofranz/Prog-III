public class Paraboloide extends Forma {

    private double curvatura;
    private double raioMax;

    public Paraboloide(double curvatura, double raioMax) {
        if (curvatura == 0) {
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
        double termo1 = Math.PI * raioMax * raioMax *
                        Math.sqrt(1 + 4 * curvatura * curvatura * raioMax * raioMax);

        double termo2 = (Math.PI / (4 * curvatura)) * 
                        Math.log(2 * curvatura * raioMax + 
                        Math.sqrt(1 + 4 * curvatura * curvatura * raioMax * raioMax));

        return termo1 + termo2;
    }
}
