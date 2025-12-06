public abstract class Forma {
    public abstract double calculaArea();

    public class Hipercubo extends Forma {
        
        private double num_dimensoes;
        private double comprimento_aresta;

        public Hipercubo(double num_dimensoes, double comprimento_aresta) {
            this.num_dimensoes = num_dimensoes;
            this.comprimento_aresta = comprimento_aresta;
        }

        @Override
        public double calculaArea(){
            return 2 * num_dimensoes * Math.pow(comprimento_aresta, num_dimensoes - 1);
        }
    }

    public class Paraboloide extends Forma {
        
        private double curvatura;
        private double raio_max;

        public Paraboloide(double curvatura, double raio_max) {
            this.curvatura = curvatura;
            this.raio_max = raio_max;
        }

        @Override
        public double calculaArea() {
            double termo1 = Math.PI * raio_max * raio_max * Math.sqrt(1 + 4 * curvatura * curvatura * raio_max * raio_max);
            double termo2 = (Math.PI / (4 * curvatura)) * Math.log(2 * curvatura * raio_max + Math.sqrt(1 + 4 * curvatura * curvatura * raio_max * raio_max));
            return termo1 + termo2;
        }

    public class Trapezio extends Forma {
        
        private double base_maior;
        private double base_menor;
        private double altura;


        public Trapezio(double base_maior, double base_menor, double altura){
            this.base_maior = base_maior;
            this.base_menor = base_menor;
            this.altura = altura;
        }

        @Override
        public double calculaArea() {
            return ((base_maior + base_menor) * altura)/2;
        }
    }
        
    }
}