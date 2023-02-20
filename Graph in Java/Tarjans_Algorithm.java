import org.w3c.dom.ls.LSOutput;

import java.security.interfaces.EdECKey;
import java.util.ArrayList;

public class Tarjans_Algorithm {
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
        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 1));
    }

    public static void dfs(ArrayList<Edge>graph[],int dt[],int low[],boolean vis[],int curr, int par,int time){
    vis[curr]=true;
    dt[curr]=low[curr]=++time;
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if(e.dest==par){
            continue;
        }
        if(vis[e.dest]){
            low[curr]=Math.min(low[curr],dt[e.dest]);
        }
        else {
            dfs(graph,dt,low,vis,e.dest,curr,time);
            low[curr]=Math.min(low[curr],low[e.dest]);

            if (dt[curr] < low[e.dest]) {
                System.out.println("Bridge is " +curr+" <---> "+ e.dest);
            }
        }
    }
    }

    public static void getBridge(ArrayList<Edge> graph[],int v){
        int dt[]=new int[v];
        int low[]=new int[v];
        boolean vis[]=new boolean[v];
        int time =0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,dt,low,vis,i,-1,time);
            }
        }
    }

    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        GraphCreate(graph);
        getBridge(graph,v);
    }
}
