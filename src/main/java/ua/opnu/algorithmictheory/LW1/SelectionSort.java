package ua.opnu.algorithmictheory.LW1;

import java.util.Arrays;

public class SelectionSort {
    private int comparisons = 0;
    private int assignments = 0;
    private int swaps = 0;

    public int[] selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            System.out.println("_________________________");
            System.out.print("Ітерація: " + i);
            System.out.println(": (i=" + i + ")");
            System.out.println("Поточний елемент (для обміну): values[" + i + "]" + " = " + values[i]);
            System.out.println("Шукаємо мінімальний елемент у масиві: " + Arrays.toString(values));

            int minIndex = i;
            assignments++;

            for (int j = i + 1; j < values.length; j++) {
                comparisons++;
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                    assignments++;
                }
            }

            System.out.println("Знайдено мінімальний елемент: values[" + minIndex + "]" + " = " + values[minIndex]);
            System.out.println("Обмін: ");
            String swap = "---";
            if (minIndex != i) {
                int temp = values[i];
                assignments++;
                swap = "values[" + i + "] " + "(" + values[minIndex] + ") <=> "
                        + "values[" + minIndex + "] " + "(" + values[minIndex] + ");";
                values[i] = values[minIndex];
                assignments++;
                values[minIndex] = temp;
                assignments++;
                swaps++;
            }
            System.out.println(swap);
            System.out.println("Масив після ітерації: " + Arrays.toString(values));
        }
        return values;
    }

    public void printStats() {
        System.out.println("Кількість порівнянь: " + comparisons);
        System.out.println("Кількість присвоєнь: " + assignments);
        System.out.println("Кількість обмінів: " + swaps);
    }
}
