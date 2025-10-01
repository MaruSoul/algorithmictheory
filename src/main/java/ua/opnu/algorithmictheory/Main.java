package ua.opnu.algorithmictheory;

import ua.opnu.algorithmictheory.LW1.InsertSort;
import ua.opnu.algorithmictheory.LW1.SelectionSort;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] values = {8, 69, 52, 97, 27, 10, 88, 29, 1, 24 };

        // LW 1 Selection Sort
        SelectionSort selectionSort = new SelectionSort();
        int[] sortedBySelection = selectionSort.selectionSort(values);

        System.out.println(Arrays.toString(sortedBySelection));

        // LW 1 Insert Sort
        InsertSort insertSort = new InsertSort();
        int[] sortedByInsert = insertSort.insertSort(values);

        System.out.println(Arrays.toString(sortedByInsert));
    }
}