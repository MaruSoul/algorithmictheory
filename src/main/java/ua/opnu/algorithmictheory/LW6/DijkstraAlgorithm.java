package ua.opnu.algorithmictheory.LW6;

import java.util.*;

public class DijkstraAlgorithm {
    // Клас для опису ребра графа
    static class Edge {
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Клас для черги пріоритетів (зберігає пару: вершина, відстань)
    static class Node implements Comparable<Node> {
        int id;
        int dist;

        public Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) {
        // Кількість вершин у графі (1-8)
        int V = 8;

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 1, 3, 6);
        addEdge(adj, 1, 4, 7);
        addEdge(adj, 1, 6, 8);

        addEdge(adj, 3, 8, 7);
        addEdge(adj, 3, 6, 3);

        addEdge(adj, 4, 2, 3);
        addEdge(adj, 4, 5, 9);

        addEdge(adj, 2, 6, 2);
        addEdge(adj, 2, 5, 4);

        addEdge(adj, 6, 8, 3);
        addEdge(adj, 6, 7, 9);

        addEdge(adj, 5, 7, 5);

        // Запуск алгоритму від вершини 1
        dijkstra(adj, V, 1);
    }

    static void addEdge(List<List<Edge>> adj, int u, int v, int w) {
        adj.get(u).add(new Edge(v, w));
        adj.get(v).add(new Edge(u, w));
    }

    static void dijkstra(List<List<Edge>> G, int numVertices, int s) {
        int[] pred = new int[numVertices + 1];
        int[] dist = new int[numVertices + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int v = 1; v <= numVertices; v++) {
            pred[v] = -1;

            if (v != s) {
                dist[v] = Integer.MAX_VALUE;
            } else {
                dist[v] = 0;
            }

            if (dist[v] != Integer.MAX_VALUE) {
                pq.add(new Node(v, dist[v]));
            }
        }

        while (!pq.isEmpty()) {
            Node uNode = pq.poll();
            int u = uNode.id;

            if (uNode.dist > dist[u]) continue;

            for (Edge edge : G.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pred[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        printResult(pred, dist, numVertices);
    }

    static void printResult(int[] pred, int[] dist, int n) {
        System.out.println("--- Результат виконання алгоритму ---");
        System.out.println(String.format("%-10s %-10s %-10s", "Вузол", "Відстань", "Батько"));
        System.out.println("------------------------------------");

        for (int i = 1; i <= n; i++) {
            String parent = (pred[i] == -1) ? "-" : String.valueOf(pred[i]);
            String distance = (dist[i] == Integer.MAX_VALUE) ? "∞" : String.valueOf(dist[i]);

            System.out.println(String.format("%-10d %-10s %-10s", i, distance, parent));
        }
    }
}
