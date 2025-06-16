public class Array {

    //Question: given an empty array , insert values 1 to n and then decrease the values by 2 (backtracking)
    public static void result(int arr[], int idx , int val){
        if( idx == arr.length){
            printArr(arr);
            return;
        }
        arr[idx] = val;
        result(arr, idx+1, val+1);
        arr[idx] = arr[idx]-2;
    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        result(arr, 0, 1);
        printArr(arr);
    }
}