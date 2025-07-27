public class Q2 {
    //MIN-MAX segment trees
    static int tree[];
    public static void init(int n){
        tree = new int[n*4];
    }

    public static void buildTree(int i , int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        buildTree(i*2+1, si, mid, arr);
        buildTree(i*2+2, mid+1, sj, arr);
        tree[i ] = Math.max(tree[2*i+1], tree[2*i+2]);
    }


    //Q: Finding max of subarray using ST
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
        if(si> qj || sj< qi){
            return Integer.MIN_VALUE;
        }else if(si>= qi && sj<=qj){
            return tree[i];
        }else{
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*i+1, si, mid, qi, qj);
            int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj){
        int n =arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }


    //Update query
    public static void updateUtil(int i, int si, int sj, int idx, int newVal){
        if(idx< si || idx > sj){
            return;
        }

        if(si == sj){
            tree[i] = newVal;
        }

        if(si!= sj){
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    }
    public static void update(int arr[], int idx, int newVal){
        int n =arr.length;
        arr[idx] = newVal;
        updateUtil(0,0,n-1,idx, newVal);
    }
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n =arr.length;
        init(n);
        buildTree(0,0,n-1,arr);

        // for (int i = 0; i < tree.length; i++) {
        //     System.out.print(tree[i]+" ");
        // }

        int max = getMax(arr, 2, 5);
        System.out.println(max);
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
    }
}
