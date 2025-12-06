public class Hipercubo extends Forma {
        
    private double num_dimensoes;
    private double comprimento_aresta;

    public Hipercubo(double num_dimensoes, double comprimento_aresta) {
        if(num_dimensoes < 1){
            throw new IllegalArgumentException("O número de dimensões deve ser pelo menos 1.");
        }
        if(comprimento_aresta <= 0){
            throw new IllegalArgumentException("O nuemro de arestas deve ser maior que zero.");
        }

        this.comprimento_aresta = comprimento_aresta;
        this.num_dimensoes = num_dimensoes;
    }

    @Override
    public double calculaArea(){
        return 2 * num_dimensoes * Math.pow(comprimento_aresta, num_dimensoes - 1);
    }
}