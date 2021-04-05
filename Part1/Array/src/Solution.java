
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            //左括号判断
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            }
            //右括号, 如果判断右括号时栈为空或者栈顶元素与右括号不等
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
