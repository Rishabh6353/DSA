import java.util.*;
public class Dp4{

    //Q: Find longest common substring
    public static int longestCommonSubstring(String s1, String s2){
        int n= s1.length();
        int m = s2.length();
        int ans = 0;
        int dp[][] = new int [n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans= Math.max(dp[i][j], ans);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }



    //Q: Find longest increasing subsequence
    public static int lcs(int arr1[], int arr2[]){
        int n =arr1.length;
        int m =arr2.length;
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int a1 = dp[i-1][j];
                    int a2 = dp[i][j-1];
                    dp[i][j] = Math.max(a1,a2);
                }
            }
        }
        return dp[n][m];
    }

    public static int longestIncreasingSubs(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int i=0;
        for(int num: set){
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }



    //Q: Edit distance LC- 72
    public static int minDistance(String word1, String word2) {
        int dp[][] = new int [word1.length()+1][word2.length()+1];

            for(int i=0; i<word1.length()+1; i++){
                for(int j = 0; j<word2.length()+1; j++){
                    if(i==0){
                        dp[i][j]=j;
                    }else if(j==0){
                        dp[i][j]= i;
                    }else if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        int a = dp[i][j-1]+1;
                        int b = dp[i-1][j]+1;
                        int c = dp[i-1][j-1]+1;
                        dp[i][j] = Math.min(Math.min(a,b),c);
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    public static void main(String[] args) {
        // String s1= "ABCDE";
        // String s2= "CD";
        // System.out.println(longestCommonSubstring(s1, s2));


        int arr[] = {10,9,2,5,3,7,101,18};
        // System.out.println(longestIncreasingSubs(arr));


        String s1 = "abc";
        String s2 = "sbd";
        System.out.println(minDistance(s1, s2));
    }
}