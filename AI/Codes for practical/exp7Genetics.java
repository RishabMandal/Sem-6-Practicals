public class exp7Genetics {
    static float[][] chromosomes = new float[6][4];
    static int crossoverPoint = 2;
    static float maxFitnessValue = 0;
    static float a, b, c, d;

    public static void main(String[] args) {
        // Range 0 - 40
        for (int i = 0; i < chromosomes.length; i++) {
            for (int j = 0; j < 4; j++) {
                chromosomes[i][j] = (float) (Math.random() * 40);
            }
        }
        float[] functionValues = new float[6];
        float[] fitnessValues = new float[6];
        float[] probabilityValues = new float[6];

        // no. of iterations = 10
        int iteration = 0;
        while (iteration++ < 10) {
            System.out.println("\nIteration " + iteration);
            fillTable(functionValues, fitnessValues, probabilityValues);
            print(chromosomes, functionValues, fitnessValues, probabilityValues);
            // Select the 6 chromosomes
            crossover(chromosomes);
            mutation(chromosomes);
            System.out.println("Maximum fitness value: " + maxFitnessValue);
            System.out.println("a:" + a + "\tb:" + b + "\tc:" + c + "\td:" + d);
        }
    }

    public static void fillTable(float[] functionValues, float[] fitnessValues, float[] probabilityValues) {
        float fitnessValueSum = 0;
        for (int i = 0; i < functionValues.length; i++) {
            functionValues[i] = function(chromosomes[i][0], chromosomes[i][1], chromosomes[i][2], chromosomes[i][3]);
            fitnessValues[i] = calculateFitness(functionValues[i]);
            fitnessValueSum += fitnessValues[i];
            // maxFitnessValue = Math.max(maxFitnessValue, fitnessValues[i]);
            if (maxFitnessValue < fitnessValues[i]) {
                maxFitnessValue = fitnessValues[i];
                a = chromosomes[i][0];
                b = chromosomes[i][1];
                c = chromosomes[i][2];
                d = chromosomes[i][3];
            }
        }
        for (int i = 0; i < probabilityValues.length; i++) {
            probabilityValues[i] = fitnessValues[i] / fitnessValueSum;
        }
    }

    // public static void roulette(float[][] chromosomes, float[] probabilityValues)
    // {
    // Maybe make clone of chromosomes
    // int[] arr = new int[100]; int index = 0;
    // for (int i = 0; i < probabilityValues.length; i++) {
    // int j = Math.round(probabilityValues[i]);
    // for (int j2 = index; j2 < j; j2++) {

    // }
    // index += j;
    // }
    // }

    public static void crossover(float[][] chromosomes) {
        for (int i = 0; i < chromosomes.length; i += 2) {
            for (int j = crossoverPoint; j < 4; j++) {
                float temp = chromosomes[i][j];
                chromosomes[i][j] = chromosomes[i + 1][j];
                chromosomes[i + 1][j] = temp;
            }
        }
    }

    public static void mutation(float[][] chromosomes) {
        int i = (int) (Math.random() * 5);
        int j = (int) (Math.random() * 3);
        chromosomes[i][j] = (float) (Math.random() * 40);
    }

    public static float function(float a, float b, float c, float d) {
        return (a + 2 * b + 3 * c + 4 * d) - 30;
    }

    public static float calculateFitness(float fx) {
        return 1 / (1 + fx);
    }

    public static void print(float[][] chromosomes, float[] functionValues, float[] fitnessValues,
            float[] probabilityValues) {
        System.out.println("a\t\tb\t\tc\t\td\t\tF(x)\t\tFitness\t\tProbability\t%");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(chromosomes[i][j] + "\t");
            }
            System.out.print(functionValues[i] + "\t");
            System.out.print(fitnessValues[i] + "\t");
            System.out.print(probabilityValues[i] + "\t");
            System.out.print(probabilityValues[i] * 100);
            System.out.println();
        }
    }
}
