public class _206_ {
}

//206. 反转链表
//https://leetcode-cn.com/problems/reverse-linked-list/
class Solution {
    //非递归实现
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next; //可能出现空指针，需要避免
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

class Solution2 {
    //递归实现 函数的功能： 传入一个链表的头节点，返回反转后链表的头结点
    public ListNode reverseList(ListNode head) {
       //边界条件
        if (head == null ||head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next); //只是返回了链表的头结点，怎么把链表拼接起来？
        head.next.next=head;
        head.next = null;
        return newHead;
    }
}