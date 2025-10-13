package ua.opnu.algorithmictheory.LW1;

public class InsertSort {
    private int comparisons = 0;
    private int assignments = 0;

    public int[] insertSort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int temp = values[i];
            assignments++;

            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (values[j] > temp) {
                    values[j + 1] = values[j];
                    assignments++;
                    j--;
                } else {
                    break;
                }
            }

            values[j + 1] = temp;
            assignments++;
        }
        return values;
    }

    public void printStats() {
        System.out.println("Comparisons = " + comparisons);
        System.out.println("Assignments = " + assignments);
    }
}
