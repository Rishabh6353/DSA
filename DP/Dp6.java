
import java.util.Arrays;

public class Dp6 {
    public static int mcm1(int arr[], int i, int j){
        if(i==j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int c1 = mcm1(arr, i, k);
            int c2 = mcm1(arr, k+1, j);
            int c3 = arr[i-1] * arr[k] * arr[j];
            int finalans = c1+c2+c3;
            ans = Math.min(ans, finalans);
        }
        return ans;
    }

     public static int mcm2(int arr[], int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int c1 = mcm2(arr, i, k,dp);
            int c2 = mcm2(arr, k+1, j,dp);
            int c3 = arr[i-1] * arr[k] * arr[j];
            int finalans = c1+c2+c3;
            ans = Math.min(ans, finalans);
        }
        return dp[i][j]= ans;
    }

    public static int mcm3(int arr[]){
        int n = arr.length;
        int dp[] [] =new int[n][n];

        for(int len=2; len<=n-1; len++){
            for (int i = 1; i <= n-len ; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<=j-1; k++){
                    int c1 = dp[i][k];
                    int c2 = dp[k+1][j];
                    int c3 = arr[i-1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], c1+c2+c3);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }

    public static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Min subset diff
    public static int minPart(int arr[]){
        int n =arr.length;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        int w = sum/2;

        int dp[][] = new int[n+1][w+1];

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <w+1 ; j++) {
                if(arr[i-1]<=j){
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }else{
                    dp[i] [j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1-sum2);
    }

    public static int minJumps(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1] = 0;
        for(int i=n-1; i>=0; i--){
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;

            for(int j=i+1; j<=steps+i && j<n; j++){
                if(dp[j] != -1){
                    ans = Math.min(dp[j]+1, ans);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,3};
        int n= arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        // System.out.println(mcm1(arr, 1, n-1));
        // System.out.println(mcm2(arr, 1, n-1, dp));
        // System.out.println(mcm3(arr));


        // int nums[] = {1,6,11,5};
        // System.out.println(minPart(nums));

        int nums[] = {2,3,1,1,4};
        System.out.println(minJumps(nums));
    }
}
