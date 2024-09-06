public class hillclimb {
    public static void sine() {
        // y = sin x (-1,1]
        // double initial = -40;
        // double max = Math.sin(Math.toRadians(initial));
        // y = -x^2
        double x = -40;
        double max = -x * x;
        double curr = max;
        while (curr >= max) {
            // initial += 10;
            // curr = Math.sin(Math.toRadians(initial));
            x += 10;
            curr = -x * x;
            max = Math.max(max, curr);
            // System.out.println("Current value: " + curr + " for value: " + initial);
            System.out.println("Current value: " + curr + " for value: " + x);
        }
        System.out.println("Maximum value is " + max);
    }

    public static void main(String[] args) {
        sine();
    }
}
