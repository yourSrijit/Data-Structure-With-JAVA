
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algo {
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt=wt;
        }

    }
    public static void graphCreate(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
         return this.cost -p2.cost;
        }
    }
    public static int primsAlgo(ArrayList<Edge> graph[],int v){
        boolean vis[]=new boolean[v];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int mstcost=0;
        while(!pq.isEmpty()){
            Pair curr =pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] =true;
                mstcost =mstcost+curr.cost;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        return mstcost;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        graphCreate(graph);
        int c=primsAlgo(graph,v);
        System.out.println("(Minimum cost of the graph in using prims algo is "+c);


    }
}
