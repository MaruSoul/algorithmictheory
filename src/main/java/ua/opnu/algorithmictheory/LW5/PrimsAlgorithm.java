package ua.opnu.algorithmictheory.LW5;

import java.util.Arrays;

public class PrimsAlgorithm {

    // Використовуємо велике число як нескінченність (замість 0, де немає ребер)
    static final int INF = 9999999;
    // Кількість вершин у твоєму графі
    static final int V = 8;

    public static void main(String[] args) {
        // Матриця суміжності (8x8)
        // Замість 0 (де немає зв'язку) ставимо INF
        int[][] graph = {
                // 1     2    3    4    5    6    7    8
                {INF,  INF,   6,   7, INF,   8, INF, INF}, // 1
                {INF,  INF, INF,   3,   4,   2, INF, INF}, // 2
                {  6,  INF, INF, INF, INF,   3, INF,   7}, // 3
                {  7,    3, INF, INF,   9, INF, INF, INF}, // 4
                {INF,    4, INF,   9, INF, INF,   5, INF}, // 5
                {  8,    2,   3, INF, INF, INF,   9,   3}, // 6
                {INF,  INF, INF, INF,   5,   9, INF, INF}, // 7
                {INF,  INF,   7, INF, INF,   3, INF, INF}  // 8
        };

        int no_edge = 0; // Кількість ребер у дереві

        // Масив для відстеження вибраних вершин
        boolean[] selected = new boolean[V];

        // Спочатку всі false
        Arrays.fill(selected, false);

        // Починаємо з 0-ї вершини (вершина "1")
        selected[0] = true;

        System.out.println("Edge : Weight");

        // Цикл працює, поки кількість ребер менша за V - 1
        while (no_edge < V - 1) {
            int min = INF;
            int x = 0; // рядок
            int y = 0; // стовпець

            // Перебираємо всі вершини
            for (int i = 0; i < V; i++) {
                // Якщо вершина 'i' вже в дереві
                if (selected[i]) {
                    // Шукаємо суміжні вершини 'j', які ще НЕ в дереві
                    for (int j = 0; j < V; j++) {
                        // Якщо 'j' не вибрана і існує ребро (менше INF)
                        if (!selected[j] && graph[i][j] != INF) {
                            // Якщо це ребро менше за поточний мінімум
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            // Виводимо знайдене ребро (додаємо +1, бо масив з 0, а вершини з 1)
            System.out.println((x + 1) + " - " + (y + 1) + " : " + graph[x][y]);

            // Додаємо вершину в дерево
            selected[y] = true;
            no_edge++;
        }
    }
}
