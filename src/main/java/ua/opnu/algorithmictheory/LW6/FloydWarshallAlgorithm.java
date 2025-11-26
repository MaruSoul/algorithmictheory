package ua.opnu.algorithmictheory.LW6;

public class FloydWarshallAlgorithm {
    final static int INF = 99999;
    final static int V = 8; // Кількість вершин

    public static void main(String[] args) {
        int[][] dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        addEdge(dist, 1, 3, 6);
        addEdge(dist, 1, 4, 7);
        addEdge(dist, 1, 6, 8);

        addEdge(dist, 2, 4, 3);
        addEdge(dist, 2, 5, 4);
        addEdge(dist, 2, 6, 2);

        addEdge(dist, 3, 6, 3);
        addEdge(dist, 3, 8, 7);

        addEdge(dist, 4, 5, 9);

        addEdge(dist, 5, 7, 5);

        addEdge(dist, 6, 8, 3);
        addEdge(dist, 6, 7, 9);

        // for k <- 1 to n do
        for (int k = 1; k <= V; k++) {
            // for i <- 1 to n do
            for (int i = 1; i <= V; i++) {
                // for j <- 1 to n do
                for (int j = 1; j <= V; j++) {
                    // D[i,j] <- min{D[i,j], D[i,k] + D[k,j]}
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        printSolution(dist);
    }

    static void addEdge(int[][] dist, int u, int v, int weight) {
        dist[u][v] = weight;
        dist[v][u] = weight;
    }

    static void printSolution(int[][] dist) {
        System.out.println("Результат автоматизованої побудови матриць відстаней");
        System.out.println("---------------------------------------------------------");

        // Заголовок стовпчиків
        System.out.print("   ");
        for (int i = 1; i <= V; i++) {
            System.out.printf("%4d ", i);
        }
        System.out.println();
        System.out.println();

        for (int i = 1; i <= V; i++) {
            // Номер рядка
            System.out.printf("%2d ", i);
            for (int j = 1; j <= V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print(" INF ");
                } else {
                    System.out.printf("%4d ", dist[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");
    }
}
