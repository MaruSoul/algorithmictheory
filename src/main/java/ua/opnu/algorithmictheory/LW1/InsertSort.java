package ua.opnu.algorithmictheory.LW1;

import java.util.Arrays;

public class InsertSort {
    private int comparisons = 0;
    private int assignments = 0;

    public int[] insertSort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            System.out.println("-------------------------");
            System.out.println("Ітерація " + i + ": (i=" + i + ")");
            int temp = values[i];
            System.out.println("Елемент для вставки (key): " + temp);
            System.out.println("Відсортована частина: " + Arrays.toString(Arrays.copyOfRange(values, 0, i)));
            assignments++;

            int j = i - 1;
            int shifts = 0;

            while (j >= 0) {
                System.out.println("Порівняння: " + values[j] + " > " + temp);
                comparisons++;
                if (values[j] > temp) {
                    System.out.println("True. Зсуваємо " + values[j] + " вправо.");
                    values[j + 1] = values[j];
                    assignments++;
                    j--;
                    shifts++;
                } else {
                    System.out.println("False. Цикл завершено.");
                    break;
                }
            }
            if (j < 0) {
                System.out.println("Досягнуто початку масиву. Цикл завершено.");
            }
            System.out.println("Вставка " + temp + " на позицію " + (j + 1) + ".");
            values[j + 1] = temp;
            assignments++;
            System.out.println("Масив після ітерації " + i + ": " + Arrays.toString(values));
        }
        return values;
    }

    public void printStats() {
        System.out.println("Comparisons = " + comparisons);
        System.out.println("Assignments = " + assignments);
    }
}
