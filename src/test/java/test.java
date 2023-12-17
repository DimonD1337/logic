import org.example.DepthFirstSearch;
import org.example.Graph;
import org.example.RandomGraphGenerator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class test {

    @Test
    public void testGraph() {
        Graph<Integer> testGraph = new Graph<>(4);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);
        testGraph.addEdge(1, 2);
        testGraph.addEdge(2, 3);

        assertEquals(List.of(1, 2), testGraph.getNeighborsIterator(0));
        assertEquals(List.of(0, 2), testGraph.getNeighborsIterator(1));

        testGraph.removeEdge(1, 2);
        assertEquals(List.of(1 , 2), testGraph.getNeighborsIterator(0));
        assertEquals(List.of(0 , 3), testGraph.getNeighborsIterator(2));
    }

    @Test
    public void testDepthFirstSearch() {
        Graph<Integer> testGraph = new Graph<>(4);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);
        testGraph.addEdge(1, 2);
        testGraph.addEdge(2, 3);

        DepthFirstSearch dfs = new DepthFirstSearch(testGraph);
        dfs.depthFirstSearch(0);
    }

    @Test
    public void testRandomGraphGenerator() {
        RandomGraphGenerator testGenerator = new RandomGraphGenerator();
        Graph<Integer> randomGraph = testGenerator.generateGraph(6, true, 0.5, 0.7);

        assertNotNull(randomGraph);
        assertEquals(6, randomGraph.getVerticesCount());
    }
}
