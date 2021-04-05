//剑指 Offer 18. 删除链表的节点
//https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/

class Solution2 {
    public ListNode deleteNode(ListNode head, int val) {
        //定义dummyHead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}


//利用递归删除val
class Solution3 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = deleteNode(head.next, val);
        return head.val == val ? head.next : head;
    }
}