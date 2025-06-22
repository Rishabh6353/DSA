
import java.util.ArrayList;

public class Question2 {

    //Question: Find if any pair in sorted AL has a target sum


    //Brute Force - O(n^2)
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        for (int i = 0; i < list.size(); i++) {
                for (int j = i=1; j < list.size(); j++) {
                    if(list.get(i)+ list.get(j)== target){
                        return true;
                    }
                }
        }
        return false;
    }


    //Optimised Approach Two pointers: O(n)
    public static boolean result2(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;

       while(lp<rp){
        if(list.get(lp)+ list.get(rp) == target){
            return true;
        }

        if(list.get(lp)+ list.get(rp) > target){
            rp--;
        }else{
            lp++;
        }
       }
       return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;
        System.out.println(result2(list,target));
    }
}
