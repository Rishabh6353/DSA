import java.util.*;

public class Graphs3 {
    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // initialising the AL
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));
        // graph[3].add(new Edge(3, 4, 1));
        // graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        // graph[4].add(new Edge(4, 5, 1));

        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // graph[6].add(new Edge(6, 5, 1));

        // graph[0].add(new Edge(0, 2, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 0, 1));

    }



    //Q: Topological sort using kahs algo(BFS)
    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]){
        for (ArrayList<Edge> graph1 : graph) {
            for (int j = 0; j < graph1.size(); j++) {
                Edge e = graph1.get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void kahns(ArrayList<Edge> graph []){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }


    //Q: Print all paths from src to dest
    public static void printAllPaths(ArrayList<Edge> graph [], int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+src);
        }
    }


    //Q: Dijkstra's algorithm - find shortest distance from src to all nodes
    public static class Pair implements Comparable <Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n= n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i != src ){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v= e.dest;
                    int wt = e.wt;

                    if(dist[u]+ wt < dist[v]){
                        dist[v] = dist[u]+ wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // kahns(graph);
        // printAllPaths(graph, 5, 1, "");
        dijkstra(graph, 0);
    }
}