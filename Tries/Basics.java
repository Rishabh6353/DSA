public class Basics {

    public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static class Node2 {
        Node2 children[] = new Node2[26];
        boolean eow = false;
        int freq;

        public Node2() {
            freq = 1;
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    public static Node2 root2 = new Node2();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void insert2(String word) {
        Node2 curr = root2;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node2();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Q: search for an element in tire
    public static boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    // Q: check if given string can be made with the words provided in array of
    // string
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    // Q: Find unique prefixes for strings in array
    public static void findPrefix(Node2 root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    // Q: write a fn to check if words in array starts with the given key
    public static boolean startsWith(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }


    //Q: count the no. of unique substrings of a string
    public static int countUniqueSubstrings(Node root){
        if(root == null){
            return 0;
        }

        int count =0;
        for(int i =0 ;i<26; i++){
             if(root.children[i]!= null){
               count+= countUniqueSubstrings(root.children[i]);
             }
        }
        return count+1;
    }


    //Q: Return the longest string from an array of string , the array should contain all the prefixes of that string
    static String ans = "";
    public static void longest(Node root, StringBuilder temp){
        if(root == null) return;

        for(int i = 0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char) (i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longest(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for (String word : words) {
        // insert(word);
        // }

        // System.out.println(search("thor"));
        // System.out.println(search("thee"));



        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(String str: words){
        // insert(str);
        // }
        // System.out.println(wordBreak("ilikesamsung"));

        // root2.freq= -1;
        // String words[] = {"dog", "dove", "duck", "zebra"};

        // for(String word: words){
        // insert2(word);
        // }

        // findPrefix(root2, "");



        // String words[] = { "apple", "app", "mango", "man", "woman" };
        // for (String word : words) {
        //     insert(word);
        // }

        // System.out.println(startsWith("app"));



        // String str = "ababa";

        // for(int i=0 ; i< str.length(); i++){
        //     String subs = str.substring(i);
        //     insert(subs);
        // }

        // int count = countUniqueSubstrings(root);
        // System.out.println(count);



        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "appl"};

        for (String word: words) {
            insert(word);
        }

        longest(root, new StringBuilder(""));
        System.out.println(ans);

    }
}