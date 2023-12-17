package org.example;
import java.util.Iterator;

class DepthFirstSearch {
    private boolean[] visited;
    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.getVerticesCount()];
    }

    public void depthFirstSearch(int startVertex) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        Iterator<Integer> neighborsIterator = graph.getNeighborsIterator(startVertex);
        while (neighborsIterator.hasNext()) {
            int neighbor = neighborsIterator.next();
            if (!visited[neighbor]) {
                // Рекурсивный вызов для непосещенных соседей
                depthFirstSearch(neighbor);
            }
        }
    }
}
