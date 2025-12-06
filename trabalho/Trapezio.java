public class Trapezio extends Forma {
    
    private double base_maior;
    private double base_menor;
    private double altura;

    public Trapezio(double base_maior, double base_menor, double altura){
        if(base_maior <= 0 || base_menor <= 0 || altura <= 0){
            throw new IllegalArgumentException("Todas as medidas devem ser maiores que zero.");
        }
        if (base_maior < base_menor) {
            throw new IllegalArgumentException("A base maior precisa reamente ser maior.");
        }
        this.base_maior = base_maior;
        this.base_menor = base_menor;
        this.altura = altura;
    }


    @Override
    public double calculaArea() {
        return ((base_maior + base_menor) * altura)/2;
    }
}
