import java.util.*;

public class Graphs5 {

    // Q1 : Find cost of cheapest flight from src to destination with atmost k
    // number of stops
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int arr[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            int src = arr[i][0];
            int dest = arr[i][1];
            int wt = arr[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static int cheapestFlights(int n, int flights[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }


    //Q: Find minimum cost to connect cities - Prim's algo
    static class Edge2 implements Comparable<Edge2>{
        int dest;
        int cost;

        public Edge2(int d, int c){
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Edge2 e2){
            return this.cost - e2.cost;
        }
    }

    public static void connectCities(int cities[][]){
        PriorityQueue<Edge2> pq = new PriorityQueue<>();
        int cost =0;
        pq.add(new Edge2(0, 0));
        boolean visited[] = new boolean[cities.length];

        while(!pq.isEmpty()){
            Edge2 curr = pq.remove();
            if(!visited[curr.dest]){
                visited[curr.dest] = true;
                cost+= curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i]!=0){
                        pq.add(new Edge2(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        System.out.println("Min cost to connect cities is: "+ cost);
    }


    //Q: Disjoint sets , Union and Find
    // static int n = 7;
    static int n = 4;
    static int par[] = new int [n];
    static int rank[] = new int [n];

    public static void init(){
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }




    //Q: Kruskal algorithm (MST)
    static class Edge3 implements Comparable<Edge3>{
        int src;
        int dest;
        int wt;

        public Edge3(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge3 e2){
            return this.wt-e2.wt;
        }
    }


    static void create(ArrayList<Edge3> edges){
        edges.add(new Edge3(0, 1, 10));
        edges.add(new Edge3(0, 2, 15));
        edges.add(new Edge3(0, 3, 30));
        edges.add(new Edge3(1, 3, 40));
        edges.add(new Edge3(2, 3, 50));
    }

    public static void kruskal(ArrayList<Edge3> edges, int V){
        init();
        Collections.sort(edges);
        int count=0;
        int cost = 0;

        for (int i = 0;  count< V-1; i++) {
            Edge3 e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if(parA != parB){
                union(e.src, e.dest);
                count++;
                cost+= e.wt;
            }
        }
        System.out.println(cost);
    }
    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;

        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[n];
        // int res=cheapestFlights(n, flights, 0, 3, 1);
        // System.out.println(res);

        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        // connectCities(cities);



        // init();
        // union(1,3);
        // System.out.println(find(3));        
        // union(2, 4);
        // System.out.println(find(4));
        // union(3, 6);
        // union(1,4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1,5);
        ArrayList<Edge3> edges = new ArrayList<>();
        create(edges);
        kruskal(edges, 4);
    }
}
