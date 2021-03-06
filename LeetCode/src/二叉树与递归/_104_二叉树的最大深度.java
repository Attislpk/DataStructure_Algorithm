package 二叉树与递归;

public class _104_二叉树的最大深度 {
}


//给定一个二叉树，找出其最大深度。
//
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//说明: 叶子节点是指没有子节点的节点。

class Solution104 {
    //从递归的出发
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //注意这里是和最小深度的区别
        return Math.max(left, right) + 1;
    }
}