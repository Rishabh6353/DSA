public class Basics {

    public static class Queue {
        static int size;
        static int arr[];
        static int rear;

        Queue(int n) {
            size = n;
            arr = new int[n];
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
            }

            rear += 1;
            arr[rear] = data;
            size++;
        }

        public int remove() {

            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q= new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}