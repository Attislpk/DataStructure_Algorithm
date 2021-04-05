package 链表;

public class _237_删除链表中的节点 {
}

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 */
class Solution237 {
    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }

        if (node.next == null){
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}