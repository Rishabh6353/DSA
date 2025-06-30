import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        Integer arr[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 620;
        int count=0;

        Arrays.sort(arr, Comparator.reverseOrder());
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
                while(arr[i]<= amount){
                    al.add(arr[i]);
                    count++;
                    amount -= arr[i];
            }
        }
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i)+" ");
        }
    }
}