import java.util.*;

public class StackUsingDeque {
    static class Stack {
        Deque<Integer> d = new LinkedList<>();

        public boolean isEmpty() {
            return d.isEmpty();
        }

        public void push(int data) {
            d.addLast(data);
        }

        public int pop() {
            return d.removeLast();
        }

        public int peek(){
            return d.getLast();
        }
    }

    public static void main(String[] args) {
        StackUsingDeque.Stack s =new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
