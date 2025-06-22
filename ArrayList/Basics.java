import java.util.ArrayList;
import java.util.Collections;

public class Basics {
    public static void reverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    public static int max(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size()-1; i++) {
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    public static void swap(ArrayList<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        System.out.println(list);
        // System.out.println(list.get(1));
        // list.remove(3);
        // System.out.println(list);
        // list.set(2, 4);
        // System.out.println(list);
        // System.out.println(list.contains(4));
        // System.out.println(list.size());

        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        // reverse(list);
        // System.out.println(max(list));

        swap(list, 0, 1);
        //    for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        //comparator
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
