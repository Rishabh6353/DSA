
import java.util.TreeMap;



public class Basics {
    public static void main(String[] args) {
        // HashMap<String, Integer> hm = new HashMap<>();
        // //put - O(1)
        // hm.put("India", 100);
        // hm.put("China", 50);
        // hm.put("Srilanka", 130);
        // hm.put("Nepal", 5);
        // hm.put("USA", 55);


        // //get - O(1)
        // System.out.println(hm.get("Indonesia"));

        // //containsKey- O(1)
        // System.out.println(hm.containsKey("India"));

        // //remove - O(1)
        // hm.remove("India");
        // System.out.println(hm);
        // System.out.println(hm.size());
        // System.out.println(hm.isEmpty());

        // //Iterator
        // Set<String> keys = hm.keySet();
        // for (String k : keys) {
        //     System.out.println("Country= "+k +" , Population = "+hm.get(k) );
        // }



        //LinkedHashMap - maintains insertion order and implemented using doubly LL
        // LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        // lhm.put("india", 100);
        // lhm.put("china", 150);
        // lhm.put("us", 50);
        // lhm.put("nepal", 5);

        // System.out.println(lhm);


        //TreeMap - key based sorting and implmeneted using Red black trees which are self balancing
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India", 50);
        tm.put("China", 150);
        tm.put("Nepal", 5);
        System.out.println(tm);
    }
}
