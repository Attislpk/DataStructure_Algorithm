package 二叉树与递归;

public class _111_二叉树的最小深度 {
}


class Solution111 {
    public int minDepth(TreeNode root) {
        //terminator
        if (root == null) return 0;

        //process drill down
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (root.left != null && root.right != null) ? Math.min(left, right) + 1: left + right + 1;

        //restore

    }
}