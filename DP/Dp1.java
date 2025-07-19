

public class Dp1 {

    //Memoization basics
    public static int fibmemo(int n, int f[]){
        if(n==0|| n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] =  fibmemo(n-1,f)+fibmemo(n-2,f);
        return f[n];
    }


    //Tabulation basics
    public static int fibTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //Q: Climbing stairs : count ways to reach nth stair , you can climb either 1 or 2 stairs at a time
    public static int climbingStairsRecursion(int n){
        if(n ==0) return 1;
        if(n<0) return 0;

        return climbingStairsRecursion(n-1)+ climbingStairsRecursion(n-2);
    }

    public static int climbingStairsMemo(int n, int f[]){
        if(n == 0) return 1;
        if (n <0) return 0;

        if(f[n] != -1){
            return f[n];
        }
        f[n] = climbingStairsMemo(n-1, f)+ climbingStairsMemo(n-2, f);
        return f[n];
    }

    public static int climbingStairsTabu(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if(i==1) {
                dp[i] = dp[i-1] + 0;
            }
            else{
                dp[i] = dp[i-1]+ dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int f[] = new int[n+1];
        // Arrays.fill(f, -1);
        // int ans = fibTab(n);
        // System.out.println(ans);

        // System.out.println(climbingStairsRecursion(n));
        // System.out.println(climbingStairsMemo(n, f));
        System.out.println(climbingStairsTabu(n));
    }
}
