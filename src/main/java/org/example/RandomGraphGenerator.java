package org.example;
import java.util.Random;

public class RandomGraphGenerator {
    private Random random;

    public RandomGraphGenerator() {
        random = new Random();
    }

    public Graph generateGraph(int V, boolean isDirected, double minDensity, double maxDensity) {
        Graph graph = new Graph(V);

        double density = random.nextDouble() * (maxDensity - minDensity) + minDensity;

        int maxEdges = isDirected ? V * (V - 1) : V * (V - 1) / 2;
        int edgeCount = (int) (maxEdges * density);

        for (int i = 0; i < edgeCount; i++) {
            int v = random.nextInt(V);
            int w = random.nextInt(V);

            // Проверка на то, что ребро еще не существует
            if (!graph.getNeighbors(v).contains(w)) {
                graph.addEdge(v, w);
                if (!isDirected) {
                    // Добавление обратного ребра для неориентированного графа
                    graph.addEdge(w, v);
                }
            }
        }

        return graph;
    }
}