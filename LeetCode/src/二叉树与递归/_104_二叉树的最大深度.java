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
        //递归终止条件
        if (root == null) return 0;
        int maxDpethLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);
        return Math.max(maxDepthRight,maxDpethLeft)+1; //每一层递归结束向上返回时树的深度在这里+1
    }
}