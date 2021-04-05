package 链表;

public class _206_删除链表中的元素 {
}

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null){
            //包含所有结点的删除逻辑
        if(cur.next.val == val){
            ListNode delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
        }else {
            cur = cur.next;
            }
        }
        return dummy.next;
    }
}