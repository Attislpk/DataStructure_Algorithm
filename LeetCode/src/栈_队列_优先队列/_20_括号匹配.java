package 栈_队列_优先队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _20_括号匹配 {
}

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()){
            //所有左括号入站
            if (ch == '['){
                stack.push(']');
            }else if (ch == '{'){
                stack.push('}');
            }else if (ch == '('){
                stack.push(')');
            }else if (stack.isEmpty()||ch!=stack.pop()){
                //如果只有右括号或者括号不匹配
                return false;
            }
        }
        //匹配结束后，栈为空则合法，不为空则不合法
        return stack.isEmpty();
    }
}