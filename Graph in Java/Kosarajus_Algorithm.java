//A directed graph is strongly connected if there is a path between all pairs of vertices.
// A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.
//For example, there are 3 SCCs in the following graph.

//Kosaraju's algorithm works in three steps-->
        //1.Get nodes in stack (Topological sort)
        //2.Transpose the graph
        //3.Do DFS according to stack nodes on the transpose graph


//Time Complexity -> O(V+E)



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Kosarajus_Algorithm {
    public static class Edge
    {
        int src;
        int  dest;
        public Edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;

        }
    }
    public static void GraphCreate( ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));

    }

    public static void dfs(ArrayList<Edge>graph[],boolean vis[],int curr)
    {
      vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e =graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,vis,e.dest);
            }
        }
    }
    /*/*/

    public static void topologicalSort(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> stack){

        vis[curr]=true;
       for(int i=0;i<graph[curr].size();i++){
           Edge e=graph[curr].get(i);
           if(!vis[e.dest]){
               topologicalSort(graph,e.dest,vis,stack);
           }
       }
       stack.push(curr);
    }


//    Step 1 ----->
    public static void KosarajusAlgo(ArrayList<Edge> graph[],int v){
        int p=1;
        Stack<Integer> stack =new Stack<>();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++) {
            if (!vis[i]) {
                topologicalSort(graph, i, vis, stack);
            }
        }
///step 2-->

       ArrayList<Edge> transpose[]=new ArrayList[v];
        for(int i=0;i<v;i++){
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++){
            vis[i]=false;
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
// step 3-->

        while (!stack.isEmpty()){
            int curr =stack.pop();
            if(!vis[curr]){
                System.out.println("Strongly connected component is no "+p++);
                dfs(transpose,vis,curr);
                System.out.println(" ");
            }
        }
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        GraphCreate(graph);
        KosarajusAlgo(graph,v);
    }
}

