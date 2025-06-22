import java.util.ArrayList;

public class Question3 {
    
     //Question: Find if any pair in sorted and rotated AL has a target sum


     //Two pointers - O(n)
    public static boolean pairSum2(ArrayList<Integer> list, int target){
         int bp = 0;
         for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)> list.get(i+1)){
                bp = i;
            }
         }

         int rp =bp;
         int lp = bp+1;

         while(lp!= rp){
            if(list.get(lp)+ list.get(rp) == target ){
                return true;
            }

            if(list.get(lp)+ list.get(rp) > target){
                rp = (rp+list.size()-1)%list.size();
            }else{
                lp = (lp+ 1) % list.size(); 
            }
         }
         return false;
    }

    public static void main(String[] args) {
         ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(pairSum2(list,target));
    }
}
