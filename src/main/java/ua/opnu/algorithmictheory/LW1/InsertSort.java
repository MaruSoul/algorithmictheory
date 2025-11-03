package ua.opnu.algorithmictheory.LW1;

import java.util.Arrays;

public class InsertSort {
    private int comparisons = 0;
    private int assignments = 0;

    public int[] insertSort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            System.out.println("-------------------------");
            int temp = values[i];
            assignments++;

            int j = i - 1;
            int shifts = 0;

            while (j >= 0) {
                comparisons++;
                if (values[j] > temp) {
                    values[j + 1] = values[j];
                    assignments++;
                    j--;
                    shifts++;
                } else {
                    break;
                }
            }

            values[j + 1] = temp;
            assignments++;
            System.out.println("Ітерація i = " + i);
            System.out.println("key = " + temp);
            System.out.println("Зсуви = " + shifts);
            System.out.println("Масив після ітерації: " + Arrays.toString(values));
        }
        return values;
    }

    public void printStats() {
        System.out.println("Comparisons = " + comparisons);
        System.out.println("Assignments = " + assignments);
    }
}
