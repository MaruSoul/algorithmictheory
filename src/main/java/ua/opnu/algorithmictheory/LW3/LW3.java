package ua.opnu.algorithmictheory.LW3;

import java.util.Arrays;

public class LW3 {
    public static void run() {
        int[] values = {12, 23, 67, 65, 50, 70, 80, 61, 92};
        Heapsort heapsort = new Heapsort();

        System.out.println("Масив до сортування купою:" + Arrays.toString(values));
        System.out.println();
        System.out.println("Купа до сортування: ");
        heapsort.getHeap(values);

        int[] result = heapsort.buildMaxHeap(values);
        System.out.println("Купа після сортування: ");
        heapsort.getHeap(result);
        System.out.println();
        System.out.println("Масив після сортування купою:" + Arrays.toString(result));
        System.out.println();
        heapsort.printStats();
    }
}
