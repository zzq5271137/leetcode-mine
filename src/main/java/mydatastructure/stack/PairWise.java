package mydatastructure.stack;

/*
 * 例题：括号匹配
 */

public class PairWise {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char topC = stack.pop();
                if (c == ')' && topC != '(')
                    return false;
                if (c == ']' && topC != '[')
                    return false;
                if (c == '}' && topC != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new PairWise().isValid("({[{}]})"));
    }

}
