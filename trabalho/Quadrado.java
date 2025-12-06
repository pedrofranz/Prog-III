public class Quadrado extends Forma {

    private double lado;
    public Quadrado(double lado){

        if (lado <= 0) {
            throw new IllegalArgumentException("O lado deve ser maior que zero.");
        }
        this.lado = lado;
    }
    
    @Override
    public double calculaArea() {
        return lado * lado;
    }
}