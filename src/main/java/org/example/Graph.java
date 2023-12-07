package org.example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T> {
    private int V; // количество вершин
    private List<Set<T>> adjacencyList; // список смежности

    public Graph(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new HashSet<>());
        }
    }

    public void addEdge(T v, T w) {
        Set<T> neighbors = new HashSet<>(adjacencyList.get(convertVertexToIndex(v)));
        if (!neighbors.contains(w)) {
            adjacencyList.get(convertVertexToIndex(v)).add(w);
            adjacencyList.get(convertVertexToIndex(w)).add(v);
        }
    }

    public void removeEdge(T v, T w) {
        adjacencyList.get(convertVertexToIndex(v)).remove(w);
        adjacencyList.get(convertVertexToIndex(w)).remove(v);
    }

    public List<T> getNeighbors(T v) {
        return new ArrayList<>(adjacencyList.get(convertVertexToIndex(v)));
    }

    public int getVerticesCount() {
        return V;
    }

    private int convertVertexToIndex(T vertex) {
        return (Integer) vertex;
    }
}
