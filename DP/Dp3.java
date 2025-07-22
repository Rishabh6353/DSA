public class Dp3 {
    //Q: Coin change
    public static int coinChange(int coin[], int sum){
        int n = coin.length;
        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(coin[i-1]<=j){
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    //Q: Rod cutting
    public static int rodCutting(int length[], int price[], int totRod){
        int n =price.length;
        int dp[][] = new int[n+1][totRod+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j <totRod+1 ; j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for(int j = 1; j< totRod+1; j++){
                if(length[i-1]<= j){
                    dp[i][j] = Math.max((price[i-1]+ dp[i][j-length[i-1]]), dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }


    //Q: Lcs recursion
    public static int lcs1(String str1, String str2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs1(str1, str2, n-1, m-1) +1;
        }else{
            int ans1 = lcs1(str1, str2, n-1, m);
            int ans2 = lcs1(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }


    //Q: Lcs memoization
     public static int lcs2(String str1, String str2, int n, int m, int dp[][]){
        if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcs2(str1, str2, n-1, m-1, dp) +1;
        }else{
            int ans1 = lcs2(str1, str2, n-1, m, dp);
            int ans2 = lcs2(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }


    //Q: lcs tabulation
    public static int lcs3(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int [n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    dp[i][j] = Math.max(a,b);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int sum = 4;
        // System.out.println(coinChange(coins, sum));


        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totRod = 8;
        // System.out.println(rodCutting(length, price, totRod));


        String str1 = "abcde";
        String str2 = "ace";
        // System.out.println(lcs1(str1, str2, str1.length(), str2.length()));
        int dp[][] = new int [str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(lcs2(str1, str2, str1.length(), str2.length(), dp));

        System.out.println(lcs3(str1, str2));
    }
}
