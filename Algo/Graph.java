package Algo;

import java.util.*;

class Graph 
{
    int noOfNodes;

    //make adj list 
    List<List<Node>> adj_list = new ArrayList<>();
   
    static class Node  //Nodes 
    {
        int value, edgeweight, srcnodeweight, desnodeweight;
        Node(int value, int edgeweight, int srcnodeweight, int desnodeweight)  
        {
            this.value = value;
            this.edgeweight = edgeweight;
            this.srcnodeweight = srcnodeweight;
            this.desnodeweight = desnodeweight;
        }
    };
 

    public Graph(List<Edges> edges)  //Constructor
    {
        int n = 0;
        // finding the max number of nodes in graph
        for (Edges e : edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));// compares current max with the new edges start and end node
        }
        noOfNodes = n+1;
        for (int i = 0; i < edges.size(); i++)
        {
            adj_list.add(i, new ArrayList<>());
        }
 
        // add edges
        for (Edges e : edges)
        {
            adj_list.get(e.src).add(new Node(e.dest, e.edgeweight, e.srcnodeweight, e.desnodeweight));
        }

        // boolean[] matched;
    }


    public static void calcslack(Graph graph)
    {
        List<Integer> slacklist=new ArrayList<Integer>(); 
        int src_vertex = 0;
        int list_size = graph.adj_list.size();
 
        while (src_vertex < list_size) 
        {
            for (Node edge : graph.adj_list.get(src_vertex)) 
            {
                slacklist.add(0, (edge.edgeweight-edge.srcnodeweight+edge.desnodeweight));
                System.out.println("Vertex: " + src_vertex + " --> " + edge.value + " - "+ slacklist);
            }
            src_vertex++;
        }        
    }


    public static void printGraph(Graph graph)  //Print adjacency list for the graph
    {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();
 
        while (src_vertex < list_size) 
        {
            for (Node edge : graph.adj_list.get(src_vertex)) 
            {
                System.out.print("Vertex: " + src_vertex + " --> " + edge.value + " (edgeweight = " + edge.edgeweight + ")" + 
                                 " (src nodeweight = " + edge.srcnodeweight + ")" + " (des nodeweight = " + edge.desnodeweight + ")\n");
            }
 
            System.out.println();
            src_vertex++;
        }
    }

}

