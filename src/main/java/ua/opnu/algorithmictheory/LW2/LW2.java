package ua.opnu.algorithmictheory.LW2;

import java.util.Arrays;

public class LW2 {
    public static void run() {
        //  Рекурсивний алгоритм алгоритму злиттям
        System.out.println("Рекурсивний алгоритм алгоритму злиттям:");
        int[] values = {12, 23, 67, 65, 50, 70, 80, 61, 92};
        System.out.println("Початковий масив: " + Arrays.toString(values));
        MergeSortRecursive mergeSortRecursive = new MergeSortRecursive();
        values = mergeSortRecursive.divide(values);
        System.out.println("Фінальний відсортований список: " + Arrays.toString(values));
        mergeSortRecursive.printStats();

        // Ітеративний алгоритм алгоритму злиттям
        System.out.println("Ітеративний алгоритм алгоритму злиттям:");
        int[] values2 = {12, 23, 67, 65, 50, 70, 80, 61, 92};
        System.out.println("Початковий масив: " + Arrays.toString(values2));
        MergeSortIterative mergeSortIterative = new MergeSortIterative();
        values2 = mergeSortIterative.mergeSortIterative(values2);
        System.out.println("Фінальний відсортований список: " + Arrays.toString(values2));
        mergeSortIterative.printStats();



        // Швидке сортування
        System.out.println("Швидке сортування:");
        int[] values3 = {12, 23, 67, 65, 50, 70, 80, 61, 92};
        System.out.println("Оригінальний список: " + Arrays.toString(values3));
        QuickSort quickSort = new QuickSort();
        values3 = quickSort.quicksort(values3, 0, values3.length - 1);
        System.out.println("Фінальний відсортований список: " + Arrays.toString(values3));
        quickSort.printStats();
    }
}
