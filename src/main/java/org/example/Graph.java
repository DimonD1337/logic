package org.example;
import java.util.*;

class Graph<T> {
    private int V; // количество вершин
    private List<Set<T>> adjacencyList; // список смежности


    public Iterator<T> getNeighborsIterator(T v) {
        return getNeighbors(v).iterator();
    }
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
        }
    }

    public void removeEdge(T v, T w) {
        adjacencyList.get(convertVertexToIndex(v)).remove(w);
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

    public Iterator<T> getNeighborsIterator(int vertex) {
        return adjacencyList.get(vertex).iterator();
    }
}
