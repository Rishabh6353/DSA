
public class Questions {
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

    // Floyd cycle finding algo in LL
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Remove cycle from LL
    public void removeCycle() {
        Node slow = head;
        Node fast = head;

        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = null;
        return;
    }

    // Merge sort on LL
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    //Print LL in zigzag fashion
    public void zigzag(){
        //find mid
        Node fast = head.next, slow= head;
        while(fast!= null && fast.next != null){
            fast=fast.next.next;
            slow= slow.next;
        }

        Node mid = slow;
        Node curr= mid.next;
        mid.next = null;

        //reversing the second part;
        Node prev = null;
        Node next;

        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //Alternate(zigzag)
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left!= null && right!= null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            //update
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        Questions list = new Questions();
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // ll.print();

        // System.out.println(ll.isCycle());
        // ll.removeCycle();
        // ll.print();
        // System.out.println(ll.isCycle());

        // LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.print();
        // list.head= list.mergeSort(list.head);
        // list.print();
        list.zigzag();
        list.print();

    }
}
