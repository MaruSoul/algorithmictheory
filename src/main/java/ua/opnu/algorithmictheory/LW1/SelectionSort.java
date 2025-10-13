package ua.opnu.algorithmictheory.LW1;

public class SelectionSort {
    private int comparisons = 0;
    private int assignments = 0;
    private int swaps = 0;

    public int[] selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int minIndex = i;
            assignments++;

            for (int j = i + 1; j < values.length; j++) {
                comparisons++;
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                    assignments++;
                }
            }

            if (minIndex != i) {
                int temp = values[i];
                assignments++;
                values[i] = values[minIndex];
                assignments++;
                values[minIndex] = temp;
                assignments++;
                swaps++;
            }
        }
        return values;
    }

    public void printStats() {
        System.out.println("Comparisons = " + comparisons);
        System.out.println("Assignments = " + assignments);
        System.out.println("Swaps = " + swaps);
    }
}
