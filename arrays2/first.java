class first {

    public static int trw(int arr[]){
        int trapped_water = 0;
        int left_max[]= new int[arr.length];
        left_max[0]= arr[0];

        for (int i = 1; i < left_max.length; i++) {
            left_max[i] = Math.max(arr[i], left_max[i-1]);
        }

        int right_max[] = new int[arr.length];
        right_max[arr.length-1]= arr[arr.length-1];


         for (int i = arr.length-2; i >= 0; i--) {
            right_max[i] = Math.max(arr[i], right_max[i+1]);
        }

        //finding trapped water on each block
        for (int i = 0; i < arr.length; i++) {
            int water_level = Math.min(left_max[i], right_max[i]);
            trapped_water += water_level-arr[i];
        }

        return trapped_water;
    }

    

    public static int stocks(int arr[]){
        int max_profit =0;
        int buy_price= Integer.MAX_VALUE;
        // int sell_price=0;

        for (int i = 0; i < arr.length; i++) {
            if(buy_price < arr[i]){
                int profit = arr[i] - buy_price;
                max_profit = Math.max(profit, max_profit);
            }
            if(buy_price> arr[i]) buy_price= arr[i];
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        int prices[] = {7,1,5,3,6,4}; 
    //    System.out.println( trw(height));
    System.out.println(stocks(prices));
    }
}