public class QueueUsingLL {
    public static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue{
        static Node head=null;
        static Node tail = null;

        public boolean isEmpty(){
            return head == null && tail == null;
        }

        public void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail =newNode;
                return;
            }

            tail.next =newNode;
            tail = newNode;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }else if(head == tail){
                int data =head.data;
                head= tail = null;
                return data;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        public int peek(){
              if(head == null && tail == null){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }else if(head.next == null){
                int data =head.data;
                head= tail = null;
                return data;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q= new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }

    }
}
