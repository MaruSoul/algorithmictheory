package ua.opnu.algorithmictheory.LW3;
import java.util.Arrays;

public class Heapsort {
    private int comparisons = 0;
    private int assignments = 0;

    public void getHeap(int[] arr) {

        for (int i = 0; i < arr.length; i = i * 2 + 1) {
            int temp = i * 2 + 1;
            int maxI = Math.min(temp, arr.length);
            int[] copy = Arrays.copyOfRange(arr, i, maxI);
            for (int k : copy) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public int[] buildMaxHeap(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        int n = result.length;
        int step = 1;

        for (int j = 0; j < result.length; j++) {
            for (int i = n / 2 - 1; i >= 0; i--) {
                sink(result, i, n);
            }

            int indexLast = result.length - 1 - j;
            if (indexLast > 0) {
                System.out.println("Крок " + step++ + ": побудова купи");
                getHeap(result);

                int temp = result[indexLast];  this.assignments++;
                result[indexLast] = result[0]; this.assignments++;
                System.out.print("Swap (" +   result[indexLast] + ", " + temp + ");    ");
                result[0] = temp;              this.assignments++;
                System.out.println(Arrays.toString(result));

                n = result.length - 1 - j;
            }

        }

        return result;
    }

    private void sink(int[] A, int i, int n) {
        int k = i;

        while (true) {
            int j = 2 * k + 1; // лівий син

            this.comparisons++;
            if (j >= n) {
                break;
            }

            this.comparisons++;
            if (j + 1 < n) {
                this.comparisons++;
                if (A[j + 1] > A[j]) {
                    this.assignments++;
                    j = j + 1;
                }
            }

            this.comparisons++;
            if (A[k] >= A[j]) {
                break;
            }

            int temp = A[k]; this.assignments++;
            A[k] = A[j];     this.assignments++;
            A[j] = temp;     this.assignments++;

            k = j;
        }
    }

    public void printStats() {
        System.out.println("Загальна кількість порівнянь: " + comparisons);
        System.out.println("Загальна кількість присвоювань: " + assignments);
    }
}
