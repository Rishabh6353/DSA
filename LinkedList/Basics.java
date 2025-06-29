public class Basics {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        // create new node
        Node newNode = new Node(data);
        size++;

        // if LL was empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // point next of new node to head node's next
        newNode.next = head;

        // make newNode the head
        head = newNode;

    }

    public void addLast(int data) {

        // create newNode
        Node newNode = new Node(data);
        size++;

        // if LL is empty
        if (head == null) {
            head = tail = newNode;
        }

        // tail's next will poiint to new node
        tail.next = newNode;

        // tail will point to newNode
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public void addMiddle(int idx, int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            // addFirst(data);
            head = tail = newNode;
            return;
        }
        Node temp = head;
        int i = 0;

        // iterate to prev Node using temp
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // when temp is prev , point newNode next to temp next and temp next to newNode
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail =null;
            size =0;
            return val;
        }

        Node prev  =head;
        for(int i = 0; i<size-2; i++){
            prev= prev.next;
        }
        int val = prev.next.data;  // or tail.data
        prev.next = null;
        tail = prev;
        size -- ;
        return  val;
    }

    public int iterativeSearch(int target){
        Node temp = head;
        int idx = 0;

        while(temp!= null){
            if(temp.data == target){
                return idx;
            }
            temp= temp.next;
            idx++;
        }
        return -1;
    }

    //helper fn for managaing head and key in recursiveSearch
    public int helper(Node head ,int target){
        if(head== null){
            return -1;
        }

        if(head.data == target){
            return 0;
        }
        
        int idx = helper(head.next, target);

        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recursiveSearch(int target){
       return helper(head, target);
    }


    public void reverse(){
        Node prev = null;
        Node curr = tail= head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        head =prev;
    }


    //Remove nTh node from end
    public void removeNthFromEnd(int n){
        int size=0;
        Node temp =head;

        while(temp!=null){
            temp =temp.next;
            size++;
        }

        if(n== size){
            head= head.next;
        }

        int idx= 1;
        int idxToFind = size- n;
        Node prev = head;
        while(idx< idxToFind){
            prev = prev.next;
            idx++;
        }
        prev.next = prev.next.next;
        return;
    }


    // Check if LL is palindrome
    public Node findMid(Node head){
        Node slow = head;
        Node fast =head;

        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow is mid node
    }

    public boolean checkPalindrome(){

        if(head == null || head.next == null){
            return true;
        }
        //find mid
        Node mid = findMid(head);

        //reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  //right half head or last value
        Node left = head;
        
        //check left half and right half
        while(right != null){
            if(left.data!= right.data){
                return false;
            }
            left = left.next;
            right= right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Basics ll = new Basics();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        // ll.print();
        // ll.addMiddle(2, 9);
        ll.print();
        // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.iterativeSearch(10));
        // System.out.println(ll.recursiveSearch(9));
        // ll.reverse();
        ll.removeNthFromEnd(3);
        ll.print();
        System.out.println(ll.checkPalindrome());
    }
}