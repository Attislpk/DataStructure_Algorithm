package 二叉树与递归;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _98_验证二叉搜索树 {
}


class Solution {
    //1.递归求解,参考下文理解
    // https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yi-zhang-tu-rang-ni-ming-bai-shang-xia-jie-zui-da-/
    public boolean isValidBSTRec(TreeNode root) {
        //传入一个根节点，判断该根节点的值是否大于左子节点，小于右子节点， 初始情况下设置左边界为Long.MIN_VAL,右边界设置为Long.MAX_VAL
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    //此处的min和val代表该节点能够属于的区间范围
    private boolean isValidBST(TreeNode root, long min, long max) {
        //terminator
        if (root == null) return true;

        //process
        if (root.val <= min || root.val >= max) return false;

        //drill down
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

        //restore
    }

    //2.使用中序遍历，BST的左-根-右需要满足递增要求，中序遍历可以使用迭代和递归，此处分别书写
    List<Integer> res = new ArrayList<>();
    public boolean isValidBSTInOrder(TreeNode root) {
        //对中序结果进行遍历，查看是否满足递增的规律
        inOrder(root);

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i + 1) <= res.get(i)) return false;
        }
        return true;
    }
    //递归的中序遍历
    private void inOrder(TreeNode root) {
        //terminator
        if (root == null) return;

        //process
        //drill down
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
        //restore
    }


    //3.非递归的二叉树中序遍历，在遍历过程中就进行值的比较
    public boolean isValidBSTInOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //前一个节点不为空，且本节点的值小于前一个节点，则不符合要求
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    //4.递归中序遍历,结合版本3+4
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //左节点判断
        if (! isValidBST(root.left)) return false;
        //当前节点判断
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        //右节点判断
        return isValidBST(root.right);
    }
}