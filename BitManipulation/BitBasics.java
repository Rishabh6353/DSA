public class BitBasics {
    public static void main(String[] args) {
        System.out.println(2&2);  //10 & 10
        System.out.println(2|2);  //10 | 10
        System.out.println(~2);   //~10 => 1s complement= 10 , 2s complement = 11 which is equal to -3
        System.out.println(2^2);  //10 ^ 10
        System.out.println(2<<1);  //10 << 1 => 100 = 4
        System.out.println(2>>1);  //10 >> 1 => 1 = 1
    }
}
