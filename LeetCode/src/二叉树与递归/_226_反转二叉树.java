package 二叉树与递归;

import java.util.Collections;

public class _226_反转二叉树 {
}



class Solution226 {
    //从方法的宏观语义出发，该方法传入一个根节点，就反转该节点的左右子树
    public TreeNode invertTree(TreeNode root) {

        //边界条件
        if (root == null)
            return null;

        //交换左右子树，其实真正的反转是在这里完成的
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}