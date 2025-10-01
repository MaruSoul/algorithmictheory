package ua.opnu.algorithmictheory.LW1;

public class InsertSort {
    public int[] insertSort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int temp = values[i];
            int j = i - 1;

            while (j >= 0 && values[j] > temp) {
                values[j + 1] = values[j];
                values[j] = temp;
                j--;
            }
            values[j + 1] = temp;
        }
        return values;
    }
}
