package 二叉树与递归;

public class _111_二叉树的最小深度 {
}


class Solution111 {
    public int minDepth(TreeNode root) {
        //当一个节点的左右子节点都为空时，该节点为叶子节点
        //递归边界
        if (root == null) return 0;

        //如果左右子树都为空，返回1
        if (root.left == null && root.right == null) return 1;

        //如果左子树or右子树中的一个为空，则返回另一个不为空子树的最小深度+1(到该root的距离包括该root)
        if (root.left == null || root.right == null){
            return minDepth(root.left) + minDepth(root.right) + 1;
        }

        //如果左右子树都不空，返回左右子树最小深度+1
        return Math.min(minDepth(root.left), minDepth(root.right)) +1;
    }
}