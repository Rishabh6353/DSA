import java.util.Stack;

public class NextGreater {

    // brute force
    // public static void nextgreat(int arr[], int res[]){
    // for (int i = 0; i < arr.length; i++) {
    // boolean flag =false;
    // for (int j = i+1; j < res.length; j++) {
    // if(arr[j]>arr[i]){
    // res[i] = arr[j];
    // flag= true;
    // break;
    // }
    // }
    // if(flag == false){
    // res[i] = -1;
    // }
    // }
    // }

    // with stack
    public static void nextgreat(int arr[], int res[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >=0; i--) {
            while (!s.isEmpty() && arr[i] > s.peek()) {
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int res[] = new int[arr.length];
        nextgreat(arr, res);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
