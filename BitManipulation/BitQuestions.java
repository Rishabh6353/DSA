public class BitQuestions {
    public static int getIthBit(int n, int i){
         if((n & (1<<i))==0){
            return 0;
         }
         return 1;
    }

     public static int setIthBit(int n, int i){
         int bitmask = 1<<i;
         int result = n | bitmask;
         return result;
    }

    public static int clearIthBit(int n, int i){
        int bitmask = ~( 1<<i);
        int result = n & bitmask;
        return result;
    }

    public static int updateIthBit(int n, int updatebit , int i){
        if(updatebit == 1){
            int bitmask = 1<<i;
            return n | bitmask;
        }else{
            int bitmask = ~(1<<i);
            return n & bitmask;
        }
    }

    public static int clearLastIthBits(int n, int i){
        int bitmask = (-1)<<i;
        return n & bitmask;
    }

    public static int clearRangeBits(int n, int i, int j){
        int a = ~(0)<<(j+1);
        int b = 1<<i-1;
        int bitmask = a|b;

        return n & bitmask;
    }

    public static boolean powOf2(int n){
        if((n & (n-1))== 0){
            return true;
        }
        return false;
    }

    public static int noOfSetBits(int n){
        int count =0;
        while(n>0){
            int lsb = n & 1;
            if((n & lsb) == 1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n=31; //11111
        int ithBit = 1; 
        int j = 3;
        // System.out.println(updateIthBit(n, ithBit,1));
        // System.out.println(clearRangeBits(n, ithBit,j));
        // System.out.println(powOf2(n));
        System.out.println(noOfSetBits(n));
    }
}