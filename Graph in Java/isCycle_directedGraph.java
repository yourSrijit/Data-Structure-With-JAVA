import java.lang.reflect.Array;
import java.util.ArrayList;

public class isCycle_directedGraph {

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
                    graph[0].add(new Edge(0, 2));
                    graph[1].add(new Edge(1, 0));
                    graph[2].add(new Edge(2, 3));
                    graph[3].add(new Edge(3, 0));

                  //graph2 - false

//                 graph[0].add(new Edge(0, 1));
//                 graph[0].add(new Edge(0, 2));
//                 graph[1].add(new Edge(1, 3));
//                 graph[2].add(new Edge(2, 3));
    }

    public static boolean isCycledirected(ArrayList<Edge> graph[],boolean vis[],boolean rec[],int current) {
        vis[current] = true;
        rec[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!vis[e.dest]) {
                if (isCycledirected(graph, vis, rec, e.dest)) {
                    return true;
                }
            }

        }
        rec[current] = false;
        return false;
    }

    public static void main(String[] args) {

        int v=4;
        int current =0;
        ArrayList<Edge> graph[]=new ArrayList[v];
        graphCreate(graph);
//        boolean vis[]=new boolean[v];
//        boolean rec[]=new boolean[v];
        boolean f=isCycledirected(graph,new boolean[v],new boolean[v],current);
        if(f){
            System.out.println("The graph have a cycle\n");
        }else {
            System.out.println("The graph have not any cycle\n");
        }


    }
}
