package Algo;
import java.util.*;

class Main{
    public static void main (String[] args) 
    {
        //Edges with weights
        System.out.println();
        List<Edges> edges = new ArrayList<>();
        
        edges.add(new Edges(0, 3, 3, 2, 1));
        edges.add(new Edges(1, 3, 2, 1, 2));
        edges.add(new Edges(2, 3, 1, 1, 2));
        edges.add(new Edges(2, 0, 3, 2, 2));
        
        // List<Edges> augmentingPath = new ArrayList<>();
        Graph graph = new Graph(edges);
        Graph.printGraph(graph);
        graph.calcslack(graph);

        List<Edges> augmentingPath = graph.findAugmentingPath();
        for (Edges edge : augmentingPath) {
            System.out.println("src: " + edge.src + ", dest: " + edge.dest);
        }
    }
}