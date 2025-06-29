import java.util.*;

public class DequeBasics {
    public static void main(String[] args) {
        Deque <Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
        System.out.println(d.isEmpty());
    }
}
