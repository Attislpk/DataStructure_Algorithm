package 二叉树与递归;

public class _437_路径总和Ⅲ {
}


/**
 给定一个二叉树，它的每个结点都存放着一个整数值。
 找出路径和等于给定数值的路径总数。
 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 **/

class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        //边界条件
        if (root == null)
            return 0;

        //包括根节点时总和为sum的情况
        int res = findPath(root, sum);
        //不包括根节点且总和为sum的情况
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);
        return res;
    }

    //以root为根节点的二叉树中，寻找包含node的路径使其和为sum，返回路径的数量
    private int findPath(TreeNode node, int sum){
        if (node == null)
            return 0;

        int res = 0;
        if (node.val == sum){
            res ++;
        }
        //如果根节点的值不等
        res += findPath(node.left,sum-node.val);
        res += findPath(node.right,sum-node.val);
        return res;
    }
}