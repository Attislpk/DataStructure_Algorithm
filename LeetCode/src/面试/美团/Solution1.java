package 面试.美团;

import java.util.HashMap;

//有一个由小写字母组成的字符串。规定，在小写字母中，每个字母的后继就是字母表中这个字母的后一个，比如a的后继是b，b的后继是c。而字母表中的最后一个字母是z，
// 为了防止z没有后继，又规定z的后继是a。这样字母的后继就形成了一个闭环。
//现在想要让字符串发生变化。每次会给出一个区间和一个数k，并且让区间中所有的字母变成他们的第k个后继。第k个后继即让后继操作进行k次
// 比如a的2级后继是c，a的26级后继是a。
//现在有操作序列和操作完之后得到的字符串。请你还原原来的字符串。
public class Solution1 {



}

class Node {

    //每个节点代表的值，对应ascii
    public int vaule;
    //节点的后继节点
    public Node next;
    public Node(int value) {
        //初始化Node的后继节点
        int i;
        for (i = 1; i < 26; i++) {
            Node n = new Node(i);
            n.next = new Node(i+1);
        }

    }

    //更新Node的后继节点
    public void updateSucc(Node origin, int k) {
        for (int i = 0; i < k; i ++) {
//            succMap.put(origin, succMap.get(origin.next));
        }
    }

}