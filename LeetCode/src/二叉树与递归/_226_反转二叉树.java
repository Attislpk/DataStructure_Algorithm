package 二叉树与递归;

import java.util.Collections;

public class _226_反转二叉树 {
}



class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        //terminator
        if (root == null) return null;

        //process  交换某节点的左右子节点
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        //drill down
        invertTree(root.left);
        invertTree(root.right);

        //restore status

        return root;
    }
}