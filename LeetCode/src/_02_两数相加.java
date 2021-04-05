public class _02_两数相加 {
}

class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建虚拟头结点
        ListNode dummyHead = new ListNode(0);
        ListNode cusor = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry !=0){
            int l1val = l1==null? 0:l1.val;
            int l2val = l2==null? 0:l2.val;

            int sum = l1val + l2val +carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            cusor.next = node;
            cusor = node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
}
