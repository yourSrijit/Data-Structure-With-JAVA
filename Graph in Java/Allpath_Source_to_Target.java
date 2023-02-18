import java.util.*;

public class Allpath_Source_to_Target {
    public static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void grpaheCreate(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));
    }

//    public static void Bfs(ArrayList<Edge>graph[],int v){
//        boolean visited[]=new boolean[v];
//        Queue<Integer> q =new ArrayDeque<>();
//        q.add(0);   //Source//
//        while(!q.isEmpty()){
//            int current =q.remove();
//            while(!visited[current]){
//                System.out.println("Current is "+current);
//                visited[current]=true;
//
//                for(int i=0;i<graph[current].size();i++){
//                    Edge e=graph[current].get(i);
//                    q.add(e.dest);
//                }
//            }
//        }
//        System.out.println();
//
//    }

    public static void Dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        if (visited[curr]) {
            return;
        }
        System.out.println(" Current is " + curr);
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            Dfs(graph,e.dest,visited);
        }
    }
//     Modified DFS
    public static void allPath(ArrayList<Edge> graph[] , boolean[] vis, int curr, String path, int target){
        if(curr == target){
            System.out.println("Path from source to target is "+path);
            return;
        }
        for(int i = 0;i<graph[curr].size(); i++){
               Edge e=graph[curr].get(i);
                if(!vis[e.dest]){
                    vis[curr]=true;
                    allPath(graph,vis,e.dest,path+e.dest,target);
                    vis[curr]=false;
            }
        }
    }

    public static void main (String[]args){

        int v = 7,tar=5,src=0;
        ArrayList<Edge> graph[] = new ArrayList[v];
        grpaheCreate(graph);
        boolean visited[] = new boolean[v];
        String path ="0";
        allPath(graph,visited,src,path,tar);
//        Dfs(graph, 0, visited);

    }

}