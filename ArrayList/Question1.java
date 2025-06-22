
import java.util.ArrayList;

public class Question1 {


    //Question: You are given n lines on x-axis along with their heights, find the maximum amount of water that can be stored using 2 lines


    //Brute force O(n^2)
    public static int ContainerWithMostWater(ArrayList<Integer> height){
        int maxWater = 0;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wd = j-1;
                int currWater = ht*wd;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    //Two pointer O(n)
    public static int result(ArrayList<Integer> height){
        int lp=0;
        int rp = height.size()-1;
        int maxWater = 0;

        while(lp<rp){
            int ht = Math.min(height.get(lp), height.get(rp));
            int wd = rp-lp;


            int currWater = ht*wd;
            maxWater = Math.max(currWater, maxWater);

            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // System.out.println(ContainerWithMostWater(height));
        System.out.println(result(height));
    }
}
