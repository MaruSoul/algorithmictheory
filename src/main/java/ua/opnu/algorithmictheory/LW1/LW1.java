package ua.opnu.algorithmictheory.LW1;

import java.util.Arrays;


public class LW1 {
    public static void run() {
        int[] values = {8, 69, 52, 97, 27, 10, 88, 29, 1, 24};
//        int[] values = {1, 8, 10, 24, 27, 29, 52, 69, 88, 97};
//        int[] values = {97, 88, 69, 52, 29, 27, 24, 10, 8, 1};


        // LW 1 Selection Sort
        System.out.println("SelectionSort");
        System.out.println("Початковий масив" +  Arrays.toString(values));
        SelectionSort selectionSort = new SelectionSort();
        int[] sortedBySelection = selectionSort.selectionSort(Arrays.copyOf(values, values.length));
        System.out.println();
        System.out.println("Сортування завершено. ");
        System.out.println("Відсортований масив: " + Arrays.toString(sortedBySelection));
        selectionSort.printStats();


        // LW 1 Insert Sort
        System.out.println("Insert Sort");
        System.out.println("Початковий масив" +  Arrays.toString(values));
        InsertSort insertSort = new InsertSort();
        int[] sortedByInsert = insertSort.insertSort(Arrays.copyOf(values, values.length));
        System.out.println("InsertSort result: " + Arrays.toString(sortedByInsert));
        insertSort.printStats();
    }
}
