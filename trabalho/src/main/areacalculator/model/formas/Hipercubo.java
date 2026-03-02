package areacalculator.model.formas;

public class Hipercubo extends Forma {
    private int numDimensoes;
    private double comprimentoAresta;

    public Hipercubo(int numDimensoes, double comprimentoAresta) {
        if (numDimensoes < 1) {
            throw new IllegalArgumentException("O número de dimensões deve ser pelo menos 1.");
        }
        if (comprimentoAresta <= 0) {
            throw new IllegalArgumentException("O comprimento da aresta deve ser maior que zero.");
        }
        this.numDimensoes = numDimensoes;
        this.comprimentoAresta = comprimentoAresta;
    }

    @Override
    public double calculaArea() {
        return 2 * numDimensoes * Math.pow(comprimentoAresta, numDimensoes - 1);
    }
}