package Algorithms.graph;

import java.util.*;

public class Graph {

    private static class Vertex {
        private String label;
        private boolean visited;
        private Vertex previous;

        public Vertex(String label, boolean visited) {
            this.label = label;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "label='" + label + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
    }

    private final List<Vertex> vertexList;
    private int[][] adjMatrix;
    private final int MAX_VERTEXES;

    public Graph(int maxVertexes) {
        MAX_VERTEXES = maxVertexes;
        this.vertexList = new ArrayList<>();
        adjMatrix = new int[maxVertexes][maxVertexes];
    }

    public void addVertex(String label) {
        if (vertexList.size() < MAX_VERTEXES)
            vertexList.add(new Vertex(label, false));
        else throw new IllegalArgumentException("Max size reached: " + MAX_VERTEXES);
    }

    public void addEdge(String startLabel, String endLabel) {
        int start = findIndex(startLabel);
        int end = findIndex(endLabel);
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void addEdge(String startLabel, String endLabel, String... more) {
        addEdge(startLabel, endLabel);
        for (String s : more) {
            addEdge(startLabel, s);
        }
    }

    private int findIndex(String label) {
        return vertexList.indexOf(new Vertex(label, true));
    }


    public void findTheShortestWay(String start, String end) {
        Vertex startVertex = vertexList.get(findIndex(start));
        Vertex endVertex = vertexList.get(findIndex(end));
        Queue<Vertex> queue = new ArrayDeque<>();
        createPath(startVertex, endVertex, startVertex, queue);
    }

    private void createPath(Vertex start, Vertex end, Vertex root, Queue<Vertex> queue) {
        start.visited = true;
        queue.add(start);

        if (start.equals(end)) {
            printPath(root, end.label);
            return;
        }

        while (!queue.isEmpty()) {
            Vertex last = queue.peek();
            int ind = getUnvisitedVertex(findIndex(last.label));
            if (ind != -1) {
                start = vertexList.get(ind);
                start.previous = root;
                createPath(start, end, root, queue);
            } else {
                queue.remove();
                root = queue.peek();
            }
        }
    }

    private void printPath(Vertex root, String endPoint) {
        Stack<String> stack = new Stack<>();
        Vertex curr = root;
        while (curr != null) {
            stack.add(curr.label);
            curr = curr.previous;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
        System.out.print(endPoint + "\n");
    }

    public void dfs(String startLabel) {
        Stack<Vertex> stack = new Stack<>();
        Vertex start = vertexList.get(findIndex(startLabel));
        start.visited = true;
        System.out.println(start);
        stack.push(start);

        while (!stack.isEmpty()) {
            Vertex current = stack.peek();
            int curInd = findIndex(current.label);
            int unvisitedInd = getUnvisitedVertex(curInd);
            if (unvisitedInd != -1) {
                Vertex next = vertexList.get(unvisitedInd);
                System.out.println(next);
                next.visited = true;
                stack.push(next);
            } else {
                stack.pop();
            }
        }
        resetState();
    }

    public void bfs(String startLabel) {
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex start = vertexList.get(findIndex(startLabel));
        start.visited = true;
        System.out.println(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.element();
            int ind = getUnvisitedVertex(findIndex(current.label));
            if (ind != -1) {
                Vertex next = vertexList.get(ind);
                next.visited = true;
                System.out.println(next);
                queue.add(next);
            } else {
                queue.poll();
            }
        }
        resetState();
    }

    private void resetState() {
        vertexList.forEach(x -> x.visited = false);
    }

    private int getUnvisitedVertex(int ver){
        for (int i = 0; i < vertexList.size(); i++) {
            if(adjMatrix[ver][i] == 1 && !vertexList.get(i).visited){
                return i;
            }
        }
        return -1;
    }

}
