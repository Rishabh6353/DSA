


public class AdvanceRecursion {

    // number of ways to place 2x1 sized tile in 2xn sized floor
    public static int TilingProblem(int n) {
        //if no space to place tiles then one way
        if (n == 0 || n == 1) {
            return 1;
        }
        //if tile is placed horizontally then (n-2) if vertically then (n-1)
        return TilingProblem(n - 1) + TilingProblem(n - 2);
    }

    //Remove duplicates in a string
    public static void duplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);

        if (map[currChar - 'a'] == true) {
            //means it already exist so we skip it
            duplicate(str, idx + 1, newStr, map);
        } else {
            //if char appears first time then flag it in map array and append it in newStr
            map[currChar - 'a'] = true;
            duplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    //friends pairing , a person can either remain single or pair up with one other , find total no. of ways 'n' people can remain single or pair up
    public static int pairs(int n) {
        //single person 1 way , 2 persons 2 ways
        if (n == 1 || n == 2) {
            return n;
        }
        //if 1 remain single then find for (n-1) , if 1 person pairs then he can be paired with (n-1) and remaning pairs can be found on (n-2) people excluding the 2 that formed pair
        return pairs(n - 1) + pairs(n - 2) * (n - 1);
    }

    //print binary string of size n without consecutive 1's
      public static void BinaryString(int n, int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        BinaryString(n-1,0,str+"0");
        if(lastPlace==0){
            BinaryString(n-1,1,str+"1");
        }
    }


    public static void main(String[] args) {
        // System.out.println(TilingProblem(4));
        String str = "aaaabbccccddd";
        int n= 5;
        int lastPlace = 0;
        String str2 = "";
        // duplicate(str, 0, new StringBuilder(""), new boolean[26]);
        BinaryString(n, lastPlace, str2);
    }
}