package ua.opnu.algorithmictheory.LW1;

import java.util.Arrays;


public class LW1 {
    public static void run() {
        int[] values = {8, 69, 52, 97, 27, 10, 88, 29, 1, 24};

        // LW 1 Selection Sort
        SelectionSort selectionSort = new SelectionSort();
        int[] sortedBySelection = selectionSort.selectionSort(Arrays.copyOf(values, values.length));
        System.out.println("SelectionSort result: " + Arrays.toString(sortedBySelection));
        selectionSort.printStats();


        // LW 1 Insert Sort
        InsertSort insertSort = new InsertSort();
        int[] sortedByInsert = insertSort.insertSort(Arrays.copyOf(values, values.length));
        System.out.println("InsertSort result: " + Arrays.toString(sortedByInsert));
        insertSort.printStats();
    }
}
