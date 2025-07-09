
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

    // Q: Count distinct elements in array
    public static int distinct(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        return hs.size();
    }

    // Q: Find union and intersection of 2 arrays
    public static void unionAndIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }

        System.out.println("Count of union= " + hs.size());

        hs.clear();

        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }

        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                count++;
                hs.remove(arr2[i]);
            }
        }

        System.out.println("Intersection: " + count);
    }


    //Q: Given from and to routes , find the correct itinerary
    public static void Itinerary(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        //finding starting point
        String start = "";
        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                start = key;
            }
        }

        System.out.print(start+"-> ");

        for(String key: tickets.keySet()){
            System.out.print(tickets.get(start)+" ->");
            start = tickets.get(start);
        }
    }


    //Q: Find length of largest subarray with sum =0
    public static int largestSubarraySum(int arr[]){
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum=0;
        int len = 0;

        for(int j=0; j<arr.length; j++){
            sum+= arr[j];

            if(hm.containsKey(sum)){
                len = Math.max(len, j - hm.get(sum));
            }else{
                hm.put(sum, j);
            }
        }
        return len;
    }


    //Q: Find number of subarrays that adds up to k
    public static int subarrayK(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int ans= 0;

        map.put(0,1);  // so that when array is of 1 element and k is that element we need to get 0 as value

        for(int j = 0; j<nums.length; j++){
            sum+= nums[j];

            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // // majority(arr);
        // String s1 = "race";
        // String s2 = "dare";
        // System.out.println(isAnagram(s1, s2));


        // System.out.println(distinct(arr));

        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};
        // unionAndIntersection(arr1, arr2);

        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put ("Chennai", "Banglore");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put ("Delhi", "Goa");
        // Itinerary(tickets);


        // int arr[] ={15,-2,2,-8,1,7,10,23};
        // System.out.println(largestSubarraySum(arr));

        int arr[]= {10,2,-2,-20,10};
        System.out.println(subarrayK(arr, -10));
    }
}