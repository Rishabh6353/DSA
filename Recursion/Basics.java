public class Basics {
    public static void decrease(int n){
        if (n==0) {
            return;
        }
        System.out.println(n);
        decrease(n-1);
    }

    public static void increase(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        increase(n-1);
        System.out.println(n);
        // return;
    }

    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }

    public static int fibonacci(int n){
        if(n ==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+ fibonacci(n-2);
    }

    public static boolean isSorted(int arr[],int i){
        if(i== arr.length-1){
            return true;
        }
        if(arr[i]> arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int target, int i){
        if(i ==  arr.length-1){
            return -1;
        }
        if(arr[i]== target){
            return i;
        }
        return firstOccurence(arr, target,i+1);
    }

    public static int lastOccurence(int arr[], int target, int i){
        if(i== arr.length-1){
            return -1;
        }
        int ans = lastOccurence(arr, target, i+1);
        if(ans == -1 && arr[i] == target){
            return i;
        }
        return ans;
    }

    public static int power(int n , int pow){
        if(pow==0){
            return 1;
        }
        return n*power(n,pow-1);
    }

    //optimised version 
    public static int power2(int n, int pow){
        if(pow ==0){
            return 1;
        }

        int halfPow = power2(n, pow/2);
        if(pow%2 ==0){
            return halfPow* halfPow;
        }
        return n * halfPow* halfPow;
    }
    public static void main(String[] args) {
        int n = 10;
        // int arr[]= {1,2,3,4,6,5,7};
        int arr[]= {6,1,3,6,4,6,8,9};
        // decrease(n);
        // increase(n);
        // System.out.println(factorial(n));
        // System.out.println(sum(n));
        // System.out.println(fibonacci(8));
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurence(arr, 6, 0));
        // System.out.println(lastOccurence(arr, 10, 0));
        System.out.println(power2(2, 5));
    }
}
