package 链表;

public class _24_两两交换链表中的节点 {
}

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */


class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return head;
        }

        //p的位置是待移动节点的前一个节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next; //因为node2确保不为空，因此node2.next最多为null，此时也不会出现问题

            //完成交换
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            //p后移到现在node1的位置，也就是next的前一个节点作为next的pre节点
            p = node1;
        }
        return dummyHead.next;
    }
}
