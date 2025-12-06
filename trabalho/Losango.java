public class Losango extends Forma{

    private double diagonal_maior;
    private double diagonal_menor;

    public Losango(double diagonal_maior, double diagonal_menor){
        if(diagonal_maior <= 0 && diagonal_menor <= 0) {
            throw new IllegalArgumentException("A diagonal maior e a diagonal menor devem ser maiores que zero.");
        }
        this.diagonal_maior = diagonal_maior;
        this.diagonal_menor = diagonal_menor;
    }

    @Override
    public double calculaArea(){
        double result = diagonal_maior  * diagonal_menor;
        return result/2;
    }
}