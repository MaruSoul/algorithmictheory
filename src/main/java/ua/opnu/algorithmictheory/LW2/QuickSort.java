package ua.opnu.algorithmictheory.LW2;

import java.util.Arrays;

public class QuickSort {
    private int comparisons = 0;
    private int assignments = 0;
    private int recursiveCalls = 0;

    public int[] quicksort(int[] a, int l, int r) {
        comparisons++;
        recursiveCalls++;

        System.out.println(
                "Quicksort виклик: масив = "
                + Arrays.toString(a)
                + ", l = " + l + ", r = " + r
        );

        if (l < r) {
            int q = partition(a, l, r);
            quicksort(a, l, q);
            quicksort(a, q + 1, r);
        }
        return a;
    }

    public int partition(int[] a, int l, int r) {
        int pivot = a[l]; assignments++;
        int i = l - 1; assignments++;
        int j = r + 1; assignments++;

        System.out.println("Вибираємо опорний елемент (pivot): " + pivot);


        while (true) {
            i++;
            assignments++;
            comparisons++;
            while (a[i] < pivot) {
                comparisons++;
                i++; assignments++;
            }
            j--; assignments++;
            comparisons++;
            while (a[j] > pivot) {
                comparisons++;
                j--; assignments++;
            }
            comparisons++;
            if (i >= j) {
                System.out.println("Індекси перетнулися. Поділ завершено. Повертаємо j=" + j);
                return j;
            }

            System.out.println(
                    "Поточні індекси: i = " + i + ", j = " + j
                    + "Обмінюємо a[" + i + "] = " + "(" + a[i] + ", "
                    + "i і a["  + j + "] = (" + a[j] + "). "
            );

            int temp = a[i]; assignments++;
            a[i] = a[j]; assignments++;
            a[j] = temp; assignments++;

            System.out.println("Масив: " +  Arrays.toString(a));

        }
    }

    public void printStats() {
        System.out.println("Загальна кількість порівнянь: " + comparisons);
        System.out.println("Загальна кількість присвоювань: " + assignments);
        System.out.println("Загальна кількість рекурсивних викликів: " + recursiveCalls);
    }
}
