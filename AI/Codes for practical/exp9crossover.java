public class exp9crossover {
    public static void main(String[] args) {
        // range 0 - 40
        int[] decimals = new int[6];
        int[][] chromosomes = new int[6][6];
        for (int i = 0; i < decimals.length; i++) {
            decimals[i] = (int) (Math.random() * 40);
        }
        decimalToChromosome(decimals, chromosomes);
        printChromosomes(chromosomes);
        int crossoverPoint = 3;
        double crossoverRate = 0.25;
        double iteration1 = Math.random();
        System.out.println("\nRandom value is " + iteration1);
        // Basically iteration less than 0.25 means less than 25%
        if (iteration1 <= crossoverRate) {
            crossover(chromosomes, crossoverPoint);
        } else
            System.out.println("Crossover not performed");
    }

    public static void crossover(int[][] chromosomes, int crossoverPoint) {
        for (int i = 0; i < chromosomes.length; i += 2) {
            for (int j = crossoverPoint + 1; j < chromosomes[0].length; j++) {
                int temp = chromosomes[i][j];
                chromosomes[i][j] = chromosomes[i + 1][j];
                chromosomes[i + 1][j] = temp;
            }
        }
        System.out.println("\n\nAfter Crossover\n");
        printChromosomes(chromosomes);
    }

    public static void decimalToChromosome(int[] decimals, int[][] chromosomes) {
        for (int i = 0; i < decimals.length; i++) {
            String binary = Integer.toBinaryString(decimals[i]);
            int k = chromosomes[0].length - 1;
            for (int j = binary.length() - 1; j >= 0; j--) {
                chromosomes[i][k--] = Integer.parseInt(binary.substring(j, j + 1));
            }
        }
    }

    public static void printChromosomes(int[][] chromosomes) {
        for (int a = 0; a < chromosomes.length; a++) {
            System.out.print("Chromosome" + (a + 1) + ": ");
            for (int i = 0; i < chromosomes[0].length; i++) {
                System.out.print(chromosomes[a][i]);
            }
            System.out.println();
        }
    }
}
