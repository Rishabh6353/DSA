import java.util.*;
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
        // TreeMap<String,Integer> tm = new TreeMap<>();
        // tm.put("India", 50);
        // tm.put("China", 150);
        // tm.put("Nepal", 5);
        // System.out.println(tm);


        //HashSet - implemented ussing hashmap , only unique keys, null is allowed, unordered.
        // HashSet<Integer> hs = new HashSet<>();
        // hs.add(1);
        // hs.add(2);
        // hs.add(3);
        // hs.add(2);
        // System.out.println(hs);

        // if(hs.contains(3)) System.out.println("True");
        // else System.out.println("false");

        // //using iterator to print
        // Iterator<Integer> i = hs.iterator();
        // while (i.hasNext()) { 
        //     System.out.print(i.next()+" ");
        // }

        // //using enhanced loop to print
        // for(Integer key: hs){
        //     System.out.println(key);
        // }


        //Linked HashSet - ordered elements
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(2);
        lhs.add(3);
        lhs.add(2);
        System.out.println(lhs);
    }
}
