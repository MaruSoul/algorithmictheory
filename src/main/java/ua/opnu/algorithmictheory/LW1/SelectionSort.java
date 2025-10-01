package ua.opnu.algorithmictheory.LW1;

public class SelectionSort {
    public int[] selectionSort(int[] values) {
       for (int i = 0; i < values.length - 1; i++) {
           int minIndex = i;
           for (int j = i + 1; j < values.length; j++) {
               if (values[j] < values[minIndex]) {
                   minIndex = j;
               }
           }

           if (minIndex != i) {
               int temp = values[i];
               values[i] = values[minIndex];
               values[minIndex] = temp;
           }
       }
        return  values;
    }
}
