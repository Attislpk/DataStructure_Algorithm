package 链表;

public class _19_删除链表的倒数第N个结点 {
}

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        assert n > 0;

        //目标：找到待删除元素的头一个节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head; //q必须从head开始才行，画图理解, 或者从dummy开始，向前移动n+1次

        //确保p和q间的距离为n，当q指向null时p指向待删除节点的前一个节点
        for (int i = 0; i < n; i++){
            if (q != null){
                q = q.next;  //最多为null,初始化q的位置
            }
        }
        while (q != null){
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next; //p.next.next肯定不为空，因为p是待删除元素的前一个，如果要删除最后一个元素，p指向的是最后一个元素的前一个元素因此p.next不可能为空
        return dummy.next;
    }
}