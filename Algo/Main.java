package Algo;
import java.util.*;

class Main{
    public static void main (String[] args) 
    {
        //Edges with weights
        System.out.println();
        List<Edges> edges = Arrays.asList(new Edges(0, 2, 3, 4, 1),
                                          new Edges(0, 3, 5, 4, 0),
                                          new Edges(1, 2, 1, 2, 1),
                                          new Edges(1, 3, 2, 2, 0));
 
        
        Graph graph = new Graph(edges);
        // Graph.printGraph(graph);
        Graph.calcslack(graph);
    }
}