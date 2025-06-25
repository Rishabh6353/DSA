import java.util.ArrayList;

public class StackUsingAL {
    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public void push(int data) {
            list.add(data);
        }

        // pop
        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(4);
        s.push(2);
        s.push(3);
        s.push(1);

        // System.out.println(s.peek());

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}