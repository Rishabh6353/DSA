import java.util.*;

public class PushAtBottom {
    //Q: push at bottom of stack

    public static void pushAtBottom(Stack<Integer> s,int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, val);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
