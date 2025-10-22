package ua.opnu.algorithmictheory.LW2;

import java.util.Arrays;

public class MergeSortIterative {
    private int comparisons = 0;
    private int assignments = 0;

    public int[] mergeSortIterative(int[] values) {
        if (values.length <= 1) {
            return values;
        }

        for (int i = 1; i < values.length; i *= 2) {
            for (int j = 0; j < values.length - i; j += 2 * i) {
                System.out.println("----------------------------------------");
                int mid = j + i;
                int right = Math.min(j + 2 * i, values.length);
                System.out.println(
                        "Об'єднуємо підмасиви: a[" + j + ":" + mid + "] "
                                + "(" + Arrays.toString(Arrays.copyOfRange(values, j, mid)) + ") "
                                + "і а[" + mid + ":" + right + "] "
                                + "(" + Arrays.toString(Arrays.copyOfRange(values, mid, right)) + ");"
                );
                merge_iterative(values, j, mid, right);

                System.out.println("Масив після об'єднання: " + Arrays.toString(values));
            }
        }

        return values;
    }

    private void merge_iterative(int[] values, int left, int mid, int right) {
        int it1 = 0; assignments++;
        int it2 = 0; assignments++;

        int[] result = new int[right - left]; assignments++;

        while (left + it1 < mid && mid + it2 < right) {
            comparisons++;
            System.out.println("Порівняння: " + values[left + it1] + " < "  + values[mid + it2]);
            if (values[left + it1] < values[mid + it2]) {
                comparisons++;
                result[it1 + it2] = values[left + it1]; assignments++;
                it1++; assignments++;
            } else {
                result[it1 + it2] = values[mid + it2]; assignments++;
                it2++; assignments++;
            }
        }

        while (left + it1 < mid) {
            comparisons++;
            result[it1 + it2] = values[left + it1]; assignments++;
            it1++; assignments++;
        }

        while (mid + it2 < right) {
            comparisons++;
            result[it1 + it2] = values[mid + it2]; assignments++;
            it2++; assignments++;
        }

        for (int i = 0; i < result.length; i++) {
            assignments++;
            values[left + i] = result[i];
        }
    }

    public void printStats() {
        System.out.println("Загальна кількість порівнянь: " + comparisons);
        System.out.println("Загальна кількість присвоювань: " + assignments);
    }
}
