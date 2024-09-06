import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Exp10A3Algo {

    public static void main(String[] args) {
        // Simulate generating a random Ki (secret key) and RAND (challenge)
        String ki = generateRandomHexString(32); // 128 bits (16 bytes) key
        String rand = generateRandomHexString(32); // 128 bits (16 bytes) challenge

        // Display the generated Ki and RAND
        System.out.println("Ki (Secret Key): " + ki);
        System.out.println("RAND (Challenge): " + rand);

        // Calculate the expected response (SRES) using the A3 algorithm
        String sres = calculateSRES(ki, rand);

        // Display the calculated SRES
        System.out.println("SRES (Expected Response): " + sres);
    }

    private static String generateRandomHexString(int length) {
        Random random = new Random();
        StringBuilder randomHex = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomInt = random.nextInt(16); // 0-15
            randomHex.append(Integer.toHexString(randomInt));
        }

        return randomHex.toString();
    }

    private static String calculateSRES(String ki, String rand) {
        try {
            // Concatenate Ki and RAND
            String input = ki + rand;

            // Use SHA-1 hash function to calculate SRES
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = sha1.digest(hexStringToByteArray(input));

            // Convert the hash to a hexadecimal string
            StringBuilder sres = new StringBuilder();
            for (byte b : hashBytes) {
                sres.append(String.format("%02X", b));
            }

            return sres.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }

        return data;
    }
}