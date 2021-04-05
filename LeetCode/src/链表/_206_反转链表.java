package 链表;


public class _206_反转链表 {
}

/**
 * 反转一个单链表。
 */

class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next; //cur不能为空，否则空指针异常,因此在此处进行next指针的移动
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev; //此时cur为空，反转后链表的头节点为prev
    }
}