public class Subsets {
    //Find subsets of strings using Backtracking

    public static void subset(String str, String ans , int idx){
        if(idx == str.length()){
            System.out.println(ans);
            return;
        }

        subset(str, ans+ str.charAt(idx), idx+1);
        subset(str, ans, idx+1);
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans="";
        subset(str, ans , 0);
    }
}
