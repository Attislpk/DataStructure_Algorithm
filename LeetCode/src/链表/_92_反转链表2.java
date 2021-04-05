package 链表;

public class _92_反转链表2 {
}

/**
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //仍然要定义dummyhead
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;   //dummyHead的位置相当于是0，到任意target的距离就是target，例如到节点2的距离就是2
        for (int i = 0; i < left - 1; i++){
            pre = pre.next;//移动left-1次将pre定位到left的前驱节点
        }

        ListNode cur = pre.next;//left的第一个节点
        ListNode next;
        //避免next.next为空，因此将next的引用放在for循环中进行
        for (int i = 0; i < right - left; i++){
            next = cur.next; //将next的位置确定，不然引用一改变就找不到了
            cur.next = next.next; //最多为null
            next.next = pre.next;//不能指向cur了，cur指向的是left节点，由于头插法，cur指针指向的元素会不断向后运动
            pre.next = next;
        }
        return dummy.next;
    }
}
