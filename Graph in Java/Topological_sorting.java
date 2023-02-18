import java.awt.dnd.DropTarget;
import java.lang.reflect.Array;
/*
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering.
Note: Topological Sorting for a graph is not possible if the graph is not a DAG.
*/

//Topo logical Sorting vs Depth First Traversal (DFS):
       // In DFS, we print a vertex and then recursively call DFS for its adjacent vertices. In topological sorting, we need to print a vertex before its adjacent vertices.
        //For example, in the given graph, the vertex ‘5’ should be printed before vertex ‘0’, but unlike DFS, the vertex ‘4’ should also be printed before vertex ‘0’.
       // So Topological sorting is different from DFS. For example, a DFS of the shown graph is “5 2 3 1 0 4”, but it is not a topological sorting.
//In topological sorting,
//
//        We use a temporary stack.
//        We don’t print the vertex immediately,
//        we first recursively call topological sorting for all its adjacent vertices, then push it to a stack.
//        Finally, print the contents of the stack.
//        Note: A vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack
//
//        Approach:
//
//        Create a stack to store the nodes.
//        Initialize visited array of size N to keep the record of visited nodes.
//        Run a loop from 0 till N
//        if the node is not marked True in visited array
//        Call the recursive function for topological sort and perform the following steps.
//        Mark the current node as True in the visited array.
//        Run a loop on all the nodes which has a directed edge to the current node
//        if the node is not marked True in the visited array:
//        Recursively call the topological sort function on the node
//        Push the current node in the stack.
//        Print all the elements in the stack.

import java.util.ArrayList;
import java.util.Stack;

public class Topological_sorting {
    int i;

    public static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void graphCreate(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        //graph1 - true
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

//    public static boolean isCycledirected(ArrayList<Edge> graph[],boolean vis[],boolean rec[],int current) {
//        vis[current] = true;
//        rec[current] = true;
//        for (int i = 0; i < graph[current].size(); i++) {
//            Edge e = graph[current].get(i);
//            if (rec[e.dest]) {
//                return true;
//            } else if (!vis[e.dest]) {
//                if (isCycledirected(graph, vis, rec, e.dest)) {
//                    return true;
//                }
//            }
//
//        }
//        rec[current] = false;
//        return false;
//    }

    public static void topologicalSorting(ArrayList<Edge>graph[],boolean vis[], Stack<Integer> stack,int current){
        vis[current]=true;

            for(int i=0; i<graph[current].size(); i++) {
                Edge e = graph[current].get(i);
            if(!vis[e.dest])
                topologicalSorting(graph,vis,stack,e.dest);
        }
        stack.push(current);
    }


    public static void main(String[] args) {

        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        graphCreate(graph);
        boolean vis[]=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i])
            {
                topologicalSorting(graph, vis,stack,i);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }
}
