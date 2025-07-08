
import java.util.HashMap;
import java.util.HashSet;

public class Questions {
    // Q: Majority Element
    public static void majority(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : hm.keySet()) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    // Q: Check if the two strings are ANAGRAM of each other
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }


    //Q: Count distinct elements in array
    public static int distinct(int arr[]){
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        return hs.size();
    }



    //Q: Find union and intersection of 2 arrays
    public static void unionAndIntersection(int arr1[], int arr2[]){
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }

        System.out.println("Count of union= "+ hs.size());

        hs.clear();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        int count =0;
        for (int i = 0; i < arr2.length; i++) {
            if(hs.contains(arr2[i])){
                count++;
                hs.remove(arr2[i]);
            }
        }

        System.out.println("Intersection: "+ count);
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // // majority(arr);
        // String s1 = "race";
        // String s2 = "dare";
        // System.out.println(isAnagram(s1, s2));


        // System.out.println(distinct(arr));

        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        unionAndIntersection(arr1, arr2);
    }
}