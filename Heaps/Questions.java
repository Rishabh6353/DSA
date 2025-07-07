import java.util.PriorityQueue;

public class Questions {

    // Q: Heap sort

    public static void heapify(int arr[], int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // push largest element at end
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    // Q: Nearby k cars in 2d plane
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    // Q: Connect n ropes such that cost is minimum (cost is combined length of 2
    // ropes)

    public static int connectRopes(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        return cost;
    }

    // Q: Weakest Soldier - given 2d binary array 1's- soldiers 0's- civillians ,
    // find index of k rows of weakest soldiers . A row is weak if no.of soldiers in
    // idx i < no.of soldiers in idx j . if equal then compare on basis of idx
    public static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    // Sliding window maximum

    public static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void slidingWindowMax(int arr[], int k, int result[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // first window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        result[0] = pq.peek().val;

        //sliding window
        for (int i = k; i < arr.length; i++) {
            while(!pq.isEmpty() && pq.peek().idx <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            result[i-k+1] = pq.peek().val;
        }

    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 4, 5, 3 };
        // heapSort(arr);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int pts[][] = {{3,3}, {5,-1},{-2,4}};
        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // int k=2;

        // for (int i = 0; i < pts.length; i++) {
        // int dist = (pts[i][0] * pts[i][0]) + (pts[i][1]* pts[i][1]);
        // pq.add(new Point(pts[i][0], pts[i][1], dist, i));
        // }

        // for(int i =0 ; i<k; i++){
        // System.out.print("C"+pq.remove().idx+" ");
        // }

        // int ropes[] = { 2, 3, 3, 4, 6 };
        // System.out.println(connectRopes(ropes));

        // int army[][] = { { 1, 0, 0, 0 },
        // { 1, 1, 1, 0 },
        // { 1, 0, 0, 0 },
        // { 1, 0, 0, 0 } };
        // int k = 2;

        // PriorityQueue<Row> pq = new PriorityQueue<>();

        // for (int i = 0; i < army.length; i++) {
        // int count = 0;
        // for (int j = 0; j < army[0].length; j++) {
        // count += army[i][j] == 1 ? 1 : 0;
        // }
        // pq.add(new Row(count, i));
        // }

        // for (int i = 0; i < k; i++) {
        // System.out.println(pq.remove().idx);
        // }

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int result[]= new int[arr.length-k+1];

        slidingWindowMax(arr, k, result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}