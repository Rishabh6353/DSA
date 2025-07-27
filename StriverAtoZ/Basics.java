import java.util.*;

public class Basics{
    public static void count(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int key : map.keySet()){
            System.out.println(key+ "-"+ map.get(key));
        }
    }

    public static void highestFreq(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            max = Math.max(max, map.get(arr[i]));
            min = Math.min(max, map.get(arr[i]));
        }

        Object keys[] = map.keySet().toArray();

        for (int i = 0; i<keys.length; i++) {
            int key = (int)keys[i];
            if(map.get(key)==max){
                System.out.println(" max is - "+ key);
            }
            if(map.get(key) == min){
                System.out.print("min key is - "+key);    
            }
        }
    }

    public static void bubble(int arr[],int s){
        if(s == 1){
            return;
        }
        for(int i=0; i<s-1; i++){
            if(arr[i]> arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubble(arr, s-1);
    }

    public static void leftRotateByOne(int arr[]){
        int temp = arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1]  = temp;
    }


    public static void printArr(int arr[]){
        for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[j]+" ");
    }
    }


    public static int duplicates(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i< arr.length; i++){
            set.add(arr[i]);
        }

        int idx= 0;
        for(Integer key : set){
            arr[idx] = key;
            idx++;
        }

        return idx;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,2,3,3,3,4};
        // count(arr);
        // highestFreq(arr);
        // bubble(arr, 8);
        // printArr(arr);
        // int ans =duplicates(arr);
        // System.out.println(ans);

        leftRotateByOne(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}