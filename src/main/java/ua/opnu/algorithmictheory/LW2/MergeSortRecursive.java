package ua.opnu.algorithmictheory.LW2;

import java.util.Arrays;

public class MergeSortRecursive {
    private int comparisons = 0;
    private int assignments = 0;
    private int recursiveCalls = 0;

    public int[] divide(int[] values) {
        recursiveCalls++;

        if (values.length <= 1) {
            return values;
        }

        int mid = values.length / 2; assignments++;


        int[] left = Arrays.copyOfRange(values, 0, mid); assignments++;
        int[] right = Arrays.copyOfRange(values, mid, values.length); assignments++;

        System.out.println("Розділяємо масив: " + Arrays.toString(left));
        System.out.println("Розділяємо масив: " + Arrays.toString(right));
        int[] resultLeft = divide(left);
        int[] resultRight = divide(right);

        return this.conquer(resultLeft, resultRight);
    }

    private int[] conquer (int[] left, int[] right) {
        System.out.println("Зливаємо: " + Arrays.toString(left) + " та " + Arrays.toString(right));
        int[] result = new int[left.length + right.length]; assignments++;
        int il = 0; assignments++;
        int ir = 0; assignments++;

        for (int i = 0; i < result.length; i++) {
            comparisons++;

            if (il < left.length && ir < right.length) {
                comparisons++;
                System.out.print("Порівняння: " + left[il] + " <= " + right[il]);
                if (left[il] <= right[ir]) {
                    System.out.println(" -> True. Додаємо " +  left[il]);
                    result[i] = left[il++]; assignments++;
                } else {
                    System.out.println(" -> False. Додаємо " +  right[ir]);
                    result[i] = right[ir++]; assignments++;
                }
            } else if (il == left.length) {
                comparisons++;
                System.out.println("Додаємо залишок з правого масиву: " +  right[ir]);
                result[i] = right[ir++]; assignments++;
            } else {
                System.out.println("Додаємо залишок з лівого масиву: " +  left[il]);
                result[i] = left[il++]; assignments++;
            }
        }

        System.out.println("Злиття завершено. Результат: " + Arrays.toString(result));
        return result;
    }

    public void printStats() {
        System.out.println("Загальна кількість порівнянь: " + comparisons);
        System.out.println("Загальна кількість присвоювань: " + assignments);
        System.out.println("Загальна кількість рекурсивних викликів: " + recursiveCalls);
    }
}
