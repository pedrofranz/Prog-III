public class fibonacci {
        public static void main(String[] args) {

        int primeiro = 1;
        int segundo = 0;
        int i;
        for(i = 1; i <= 30; i++) {
            int soma = primeiro + segundo;
            primeiro = segundo;
            segundo = soma;
            System.out.println(segundo);
        }
        }
}

