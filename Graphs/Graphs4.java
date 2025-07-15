
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graphs4 {
    public static class Edge{
        int src;
        int dest;
        int wt;


        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt =wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
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
        // graph[4].add(new Edge(4, 1, -1));

    }
    public static void createGraph2(ArrayList<Edge> graph){
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 2, 30));
        graph.add(new Edge(1, 0, -10));
        graph.add(new Edge(1, 3, -40));
        graph.add(new Edge(2, 0, 15));
        graph.add(new Edge(2, 3, 50));
        graph.add(new Edge(3, 1, 40));
        graph.add(new Edge(3, 2, 50));

    }

    //Q: Bellman ford algorithm for negative weights
    public static void bellman(ArrayList<Edge> graph, int source, int V){
        int dist[] = new int[V];

        for (int i = 0; i < dist.length; i++) {
            if(i!= source){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V-1; i++) {
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[v]> dist[u]+wt){
                    dist[v] = dist[u]+wt;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
    }


    //Q: Prims algorithm
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
        pq.add(new Pair(0, 0));
        int finalCost=0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost+= curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // bellman(graph, 0, V);
        prims(graph);
    }
}
