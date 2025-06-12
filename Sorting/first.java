class first{

    public static void swap (int arr[], int i, int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubble(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void selection(int arr[]){
        for (int i = arr.length-1; i>=0; i--) {
            int max =0;
            for (int j = 0; j <= i; j++) {
                if(arr[j]>arr[max]) max = j;
            }
            swap(arr,i,max);
        }
    }

    public static void insertion(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {9,5,3,1,4,6};
        bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}