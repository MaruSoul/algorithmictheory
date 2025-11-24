package ua.opnu.algorithmictheory.LW5;

import java.util.ArrayList;
import java.util.Collections;

class Graph {
    // Клас для представлення ребра
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Метод для сортування ребер за вагою
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    int V; // Кількість вершин
    ArrayList<Edge> edges = new ArrayList<>(); // Всі ребра графа
    ArrayList<Edge> mst = new ArrayList<>();   // Ребра, що увійдуть в MST

    // Масив для збереження "батька" вершини (для перевірки циклів)
    int[] parent;

    // Конструктор
    Graph(int v) {
        V = v;
        parent = new int[V];
        // Спочатку кожна вершина сама собі "батько"
        for (int i = 0; i < V; i++)
            parent[i] = i;
    }

    // Додавання ребра (конвертуємо нумерацію 1-8 у 0-7 для Java)
    void addWeightedEdge(int u, int v, int w) {
        edges.add(new Edge(u - 1, v - 1, w));
    }

    // Знайти головного представника множини (find set)
    int find_set(int i) {
        if (i == parent[i])
            return i;
        else
            return find_set(parent[i]);
    }

    // Об'єднати дві множини (union set)
    void union_set(int u, int v) {
        parent[u] = parent[v];
    }

    // Головний метод алгоритму Краскала
    void kruskal() {
        // 1. Сортуємо всі ребра за зростанням ваги
        Collections.sort(edges);

        int edgeCount = 0;
        int i = 0;

        // Перебираємо відсортовані ребра
        while (edgeCount < V - 1 && i < edges.size()) {
            Edge next_edge = edges.get(i++);

            int x = find_set(next_edge.src);
            int y = find_set(next_edge.dest);

            // Якщо вершини належать до різних множин (немає циклу)
            if (x != y) {
                mst.add(next_edge); // Додаємо в дерево
                union_set(x, y);    // Об'єднуємо множини
                edgeCount++;
            }
        }
    }

    // Вивід результату
    void print() {
        System.out.println("Edge : Weight");
        int totalCost = 0;
        for (Edge e : mst) {
            // При виводі додаємо +1, щоб повернути нумерацію 1-8
            System.out.println((e.src + 1) + " - " + (e.dest + 1) + " : " + e.weight);
            totalCost += e.weight;
        }
        System.out.println("Total Cost: " + totalCost);
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        // У графі 8 вершин
        Graph g = new Graph(8);

        // Додаємо ребра з графа
        // (u, v, weight)
        g.addWeightedEdge(1, 3, 6);
        g.addWeightedEdge(1, 4, 7);
        g.addWeightedEdge(1, 6, 8);

        g.addWeightedEdge(2, 4, 3);
        g.addWeightedEdge(2, 5, 4);
        g.addWeightedEdge(2, 6, 2);

        g.addWeightedEdge(3, 6, 3);
        g.addWeightedEdge(3, 8, 7);

        g.addWeightedEdge(4, 5, 9);

        g.addWeightedEdge(5, 7, 5);

        g.addWeightedEdge(6, 7, 9);
        g.addWeightedEdge(6, 8, 3);

        // Запуск алгоритму
        g.kruskal();
        g.print();
    }
}
