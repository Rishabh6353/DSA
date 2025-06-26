import java.util.Stack;

public class DuplicateParentheses {

    public static  boolean valid(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;

                while(s.peek() != '('){
                    s.pop();
                    count++;
                }

                if(count==0){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "(((a+b)+(c+d))+e)";
        boolean res = valid(str);
        System.out.println(res);
    }
}
