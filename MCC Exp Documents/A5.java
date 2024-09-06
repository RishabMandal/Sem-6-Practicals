import java.lang.Math;

public class A5 {
    static int[] GenerateBits() {
        int[] a = new int[16];
        for (int i = 0; i < 16; i++) {
            double rand = Math.random();
            if (rand >= 0.5) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        return a;
    }

    static int[] XOR(int[] a, int[] b) {
        int[] temp = new int[16];
        for (int i = 0; i < 16; i++) {
            if (a[i] == 1 && b[i] == 1 || a[i] == 0 && b[i] == 0) {
                temp[i] = 0;
            } else {
                temp[i] = 1;
            }
            System.out.print(temp[i]);
        }
        return temp;
    }

    static int[] AND(int[] a, int[] b) {
        int[] temp = new int[16];
        for (int i = 0; i < 16; i++) {
            if (a[i] == 1 && b[i] == 1) {
                temp[i] = 1;
            } else {
                temp[i] = 0;
            }
            System.out.print(temp[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] a;
        System.out.println("Generating the 1st key identification number");
        a = GenerateBits();
        for (int i = 0; i < 16; i++) {
            System.out.print(a[i]);
        }
        int[] b;
        System.out.println("\n\nGenerating the 2nd key identification number");
        b = GenerateBits();
        for (int i = 0; i < 16; i++) {
            System.out.print(b[i]);
        }
        int[] c;
        System.out.println("\n\nGenerating the random number");
        c = GenerateBits();
        for (int i = 0; i < 16; i++) {
            System.out.print(c[i]);
        }
        int[] d;
        System.out.println("\n\nGenerating the barker code");
        d = GenerateBits();
        for (int i = 0; i < 16; i++) {
            System.out.print(d[i]);
        }
        int[] z;
        System.out.println("\n\nAND of 1st key and 2nd key");
        z = AND(a, b);
        int[] p;
        System.out.println("\n\nXOR of random number and the AND of 1st key and 2nd key");
        p = XOR(z, c);
        System.out.println("\n\nXOR of the above number and barker code");
        p = XOR(p, d);
        int[] q;
        System.out.println("\n\nXOR of random number and the AND of 1st key and 2nd key");
        q = XOR(z, c);
        System.out.println("\n\nXOR of the above number and barker code");
        q = XOR(q, d);
        int flag = 0;
        for (int i = 0; i < 16; i++) {
            if (p[i] != q[i]) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.print("\n\nEncryption Failed");
        } else {
            System.out.print("\n\nEncryption Passed");
        }

    }
}
