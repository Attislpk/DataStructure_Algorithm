package 二叉树与递归;

public class _112_到叶子节点的总和 {
}


class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null){
//            //判断条件是，如果某节点的下一层节点为空(说明该节点为叶子节点)，则判断到达该叶子节点时sum的值是否减少为0
//            return targetSum == 0;
//        }
//
//        if (hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val)){
//            return true;
//        }
//        return false;
//    }

        //此时需要对根节点进行判断
        if (root == null) return false;

        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }

        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}