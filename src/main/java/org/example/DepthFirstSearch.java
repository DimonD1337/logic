package org.example;
import java.util.List;

public class DepthFirstSearch {
    private boolean[] visited;
    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVerticesCount()];
    }

    public void depthFirstSearch(int startVertex) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        List<Integer> neighbors = graph.getNeighbors(startVertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                // Рекурсивный вызов для непосещенных соседей
                depthFirstSearch(neighbor);
            }
        }
    }
}