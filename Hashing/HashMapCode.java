
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {

    static class HashMap<K, V> { // generic data type K and V
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n
        private int N; 
        private LinkedList<Node> buckets[]; // N

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFun(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;   // so that bucket key remains in a fixed range
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];  //storing linked list on bucket index as ll
            int di=0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key){
                    return di;  // return data index if key found at ith index of LL
                }
                di++;
            }
            return -1;  //if key not found
        }

        @SuppressWarnings("unchecked")
        public void rehash(){
            LinkedList<Node> oldBucket [] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            //nodes -> add in bucket
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFun(key);  // return values between 0 and 3
            int di = searchInLL(key,bi); // invalid returns : -1

            if(di!=-1){
                Node node = buckets[bi].get(di);
                node.value = value;   //if key already exists in LL then update the value of key
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n /N;
            if(lambda>2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFun(key);  // return values between 0 and 3
            int di = searchInLL(key,bi); // invalid returns : -1

            if(di!=-1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFun(key);  // return values between 0 and 3
            int di = searchInLL(key,bi); // invalid returns : -1

            if(di!=-1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
               return null;
            }
        }

        public V remove(K key){
            int bi = hashFun(key);  // return values between 0 and 3
            int di = searchInLL(key,bi); // invalid returns : -1

            if(di!=-1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }


    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 100);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();
        for(String key: keys){
            System.out.println(hm.get(key));
        }
    }
}