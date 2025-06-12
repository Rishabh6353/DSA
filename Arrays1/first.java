
class first {

    public int Linear(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("key found at index : " + i);
                return i;
            }
        }
        return -1;
    }


    public static int largest(int arr[]){
        int largest = 0;
        for(int i=0; i< arr.length;i++){
            if(arr[i]>arr[largest]){
                largest = i;
            }
        }
        return largest;
    }

    public static int Binary(int arr[], int target){
        int start = 0;
        int end = arr.length-1;

        while(start<= end){
            int mid = (start+end)/2;
            if(arr[mid]== target){
                return mid;
            }
            else if(arr[mid]<target){
                start= mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static void reverse(int arr[]){
        int first = 0;
        int last =  arr.length-1;

       while(first<last){
            int temp = arr[last];
            arr[last]= arr[first];
            arr[first]= temp;
            first++;
            last--;
        }
    }

    public static void pairs(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
            System.out.println("("+arr[i]+ "," + arr[j]+ ")");
            }
        }
    }

    public static void subarray(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int current = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    System.out.print(arr[j2]+"");
                    current+= arr[j2];
                }
                if(current> maxSum){
                    maxSum= current;
                }
                System.out.println( );
            }
        }
        System.out.println(maxSum);
    }

      public static void prefix(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int current ;
        int prefixSum[]= new int[arr.length];
        prefixSum[0]= arr[0];

        //calculate prefixSumArray
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                current = i==0 ? prefixSum[j]: prefixSum[j]-prefixSum[i-1];
            
            if(current> maxSum) maxSum= current;
        }
    }
        System.out.println(maxSum);
}


    public static int kadane(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int current= 0;

        for (int i = 0; i < arr.length; i++) {
            current+= arr[i];
            if(maxSum< current){
                maxSum= current;
            }
            if(current<0) current =0;
        }
        return maxSum;
    }

    public static void main(String args[]) {
        // int marks[]= {1,2,3,4,5};
        // for (int i = 0; i < marks.length; i++) {
        // System.out.println(marks[i]);
        // }

        // input
        // int nums[]= new int[10];
        // Scanner sc = new Scanner(System.in);

        // for (int i = 0; i < nums.length; i++) {
        // nums[i]= sc.nextInt();
        // System.out.println(nums[i]);
        // }

        // Linear search
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // int target = 9;

        // int largestIndex = largest(nums);
        // int answer = Binary(nums, target);
        // System.out.println(answer);

        // reverse(nums);
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.println(nums[i]);
        // }
        // pairs(nums);
        System.out.println(kadane(nums));
    }
}
