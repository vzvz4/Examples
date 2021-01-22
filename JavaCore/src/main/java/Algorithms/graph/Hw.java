package Algorithms.graph;

public class Hw {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Graph test = new Graph(6);
        test.addVertex("A");
        test.addVertex("B");
        test.addVertex("C");
        test.addVertex("D");
        test.addVertex("E");
        test.addVertex("F");

        test.addEdge("A", "B", "C", "D");
        test.addEdge("B", "E");
        test.addEdge("E", "F");

        //   / B - E - F
        // A - C
        //   \ D

        // Expected A B E F C D
        test.dfs("A");

        System.out.println("----------------------");

        // Expected A B C D E F
        test.bfs("A");

        // Expected C -> A -> D
        test.findTheShortestWay("C", "D");
    }
}
