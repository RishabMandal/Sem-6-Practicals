import java.util.*;

class Exp8FrequencyReuse {
    // Online Java Compiler

    private int i;
    private int j;

    public Exp8FrequencyReuse(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Method to calculate the total number of available frequencies
    public int calculateTotalFrequencies() {
        return (i * i) + (i * j) + (j * j);
    }

    // Method to determine if two cells are co-channels
    public boolean areCoChannels(int cell1, int cell2) {
        // Formula to check if two cells are co-channels
        return Math.abs(cell1 - cell2) % (i + j) == 0;
    }

    public static void main(String[] args) {
        // Example values of i and j
        int i = 2;
        int j = 1;

        Exp8FrequencyReuse frequencyReuse = new Exp8FrequencyReuse(i, j);

        // Calculate total frequencies
        int totalFrequencies = frequencyReuse.calculateTotalFrequencies();
        System.out.println("Total available frequencies: " + totalFrequencies);

        // Example check for co-channels
        int cell1 = 3;
        int cell2 = 5;
        boolean coChannels = frequencyReuse.areCoChannels(cell1, cell2);
        System.out.println("Are cell " + cell1 + " and cell " + cell2 + " co-channels? " + coChannels);
    }
}