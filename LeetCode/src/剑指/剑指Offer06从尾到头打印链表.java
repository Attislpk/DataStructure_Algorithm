package 剑指;


import java.util.ArrayList;
import java.util.Stack;

//public class 从尾到头打印链表 {
//}


class Solution06 {
    //思路1.反转链表，然后顺序打印, ！！！！！最笨的方法！！！！！
    //同理，也可以将ArrayList逆序输出
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int size = array.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = array.get(size - i - 1);
        }
        return result;
    }

    //思路2.使用栈结构，FILO
    //如果使用数组，数组的长度开多大？  如果使用ArrayList，如何将Object[]转换为int[]?  傻呀！ 栈的大小不就是数组的大小吗？
    public static int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) res[i++] = stack.pop();
        return res;
    }

    //思路3：递归的本质
    public int[] reversePrint3(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();
        recur(head, array);
        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }
        return res;
    }

    private void recur(ListNode head, ArrayList<Integer> array) {
        if (head == null) return;
        recur(head.next, array);
        array.add(head.val);
    }
}