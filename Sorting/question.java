
import java.util.Arrays;

public class question {

    public static boolean dupl(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean anagram(String str1 , String str2){
        str1= str1.toLowerCase();
        str2= str2.toLowerCase();

        if(str1.length() == str2.length()){
            char[] str1Array = str1.toCharArray();
            char[] str2Array = str2.toCharArray();

            Arrays.sort(str1Array);
            Arrays.sort(str2Array);

            if(Arrays.equals(str2Array,str1Array)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        // if(dupl(arr)){
        //     System.out.println("true");
        // }else{
        //     System.out.println("false");
        // }
        String str1= "care";
        String str2= "rece";
        System.out.println(anagram(str1, str2));
    }
}
