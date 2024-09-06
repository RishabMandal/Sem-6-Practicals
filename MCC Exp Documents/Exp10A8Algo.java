public class Exp10A8Algo {
    // Secret key (Ki)
    private static final int[] KI = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };

    // A8 Algorithm
    public static int[] generateKeyStream(int[] rand) {
        int[] keyStream = new int[rand.length];

        // Generate key stream
        for (int i = 0; i < rand.length; i++) {
            keyStream[i] = rand[i] ^ KI[i % KI.length];
            System.out.printf("Step %d: RAND = %d, KI = %d, Key Bit = RAND ^ KI = %d ^ %d = %d\n",
                    i + 1, rand[i], KI[i % KI.length], rand[i], KI[i % KI.length], keyStream[i]);
        }

        return keyStream;
    }

    // Example usage
    public static void main(String[] args) {
        // Example random number (RAND)
        int[] rand = { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 };

        // Generate key stream using A8 algorithm
        int[] keyStream = generateKeyStream(rand);

        // Print key stream
        System.out.println("\nKey Stream:");
        for (int keyBit : keyStream) {
            System.out.print(keyBit);
        }
    }
}
