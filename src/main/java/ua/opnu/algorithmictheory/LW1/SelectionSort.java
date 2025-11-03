package ua.opnu.algorithmictheory.LW1;

import java.util.Arrays;

public class SelectionSort {
    private int comparisons = 0;
    private int assignments = 0;
    private int swaps = 0;

    public int[] selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            System.out.println("_________________________");
            System.out.println("Ітерація: " + i);
            int minIndex = i;
            assignments++;

            for (int j = i + 1; j < values.length; j++) {
                comparisons++;
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                    assignments++;
                }
            }

            System.out.println("minIndex: " + minIndex);
            String swap = "---";
            if (minIndex != i) {
                int temp = values[i];
                assignments++;
                swap = temp + " <=> " +  values[minIndex];
                values[i] = values[minIndex];
                assignments++;
                values[minIndex] = temp;
                assignments++;
                swaps++;
            }
            System.out.println(swap);
            System.out.println("Масив після ітерації: " + Arrays.toString(values));
        }
        return values;
    }

    public void printStats() {
        System.out.println("Comparisons = " + comparisons);
        System.out.println("Assignments = " + assignments);
        System.out.println("Swaps = " + swaps);
    }
}
