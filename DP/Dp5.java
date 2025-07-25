import java.util.*;
public class Dp5 {
    public static boolean wildcard(String s1, String s2){
        int n =s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int i=1; i<n+1; i++){
            dp[i][0] =false;
        }
        for(int j=1; j<m+1; j++){
            if(s2.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <m+1; j++) {
                if((s1.charAt(i-1) == s2.charAt(j-1) ) || s2.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s2.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }


    //Q: catlan number - recursion
    public static int catlanRec(int n){
        if(n== 0 || n==1){
            return 1;
        }
        int ans =0;
        for(int i=0; i<n; i++){
            ans+= catlanRec(i) * catlanRec(n-1-i);
        }
        return ans;
    }

    public static int catlanMemo(int n, int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!= -1){
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans+= catlanMemo(i, dp) * catlanMemo(n-1-i, dp);
        }
        return dp[n] = ans;
    }

    public static int catlanTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1]= 1;

        for (int i = 2; i < n+1; i++) {
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }


    //Q: count no of bst
     public static int bstcount(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1]= 1;

        for (int i = 2; i < n+1; i++) {
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    //Q: Mountain ranges
     public static int mountainRanges(int n){
        //n is no. of pairs , one pair has one upstroke and one downstroke
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1]= 1;

        for (int i = 2; i < n+1; i++) {
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        String s1 = "baaabab";
        String s2 = "*****ba*****abb";
        // System.out.println(wildcard(s1,s2));
        int n =4;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        // System.out.println(catlanRec(4));
        // System.out.println(catlanMemo(n, dp));
        // System.out.println(catlanTab(n));
        // System.out.println(bstcount(4));
        System.out.println(mountainRanges(n));

    }
}
