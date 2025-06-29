
import java.util.*;

public class QueueUsingDeque {
    public  class Queue{
        Deque <Integer> d  = new LinkedList<>();

        public void add (int data){
            d.addLast(data);
        }

        public int remove(){
            return d.removeFirst();
        }

        public int peek(){
            return d.getFirst();
        }
    }
    public static void main(String[] args) {
        QueueUsingDeque o = new QueueUsingDeque();
        Queue q = o.new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

    }
}
