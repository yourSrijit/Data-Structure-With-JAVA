import java.util.ArrayList;
//This step initializes distances from the source to all vertices as infinite and distance to the source itself as 0. Create an array dist[] of size |V| with all values as infinite except dist[src] where src is source vertex.
//        This step calculates shortest distances. Do following |V|-1 times where |V| is the number of vertices in given graph. Do following for each edge u-v
//        If dist[v] > dist[u] + weight of edge uv, then update dist[v] to
//        dist[v] = dist[u] + weight of edge uv
//        This step reports if there is a negative weight cycle in the graph. Again traverse every edge and do following for each edge u-v
//        ……If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle”
//        The idea of step 3 is, step 2 guarantees the shortest distances if the graph doesn’t contain a negative weight cycle. If we iterate through all edges one more time and get a shorter path for any vertex, then there is a negative weight cycl

public class BellmanFord {
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
    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<graph.length-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt <dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }

        }
         int j=0;
        for(int i=0;i<dist.length;i++){
            System.out.println("Minimum weight of graph from 0 to "+ j +" is "+dist[i]);
            j++;
        }
    }
    public static void graphCreate(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }


    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        graphCreate(graph);
        int src=0;
        bellmanFord(graph,src);
    }
}
