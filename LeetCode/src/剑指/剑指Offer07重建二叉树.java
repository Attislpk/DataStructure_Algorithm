package 剑指;

import java.util.HashMap;

public class 剑指Offer07重建二叉树 {
}

class Solution07 {
    //前序：根左右  中序：左根右
    //存放中序遍历中各个节点的位置，根据前序遍历的结果，可以直接定位到中序遍历结果中的位置
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return treeBuilder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode treeBuilder(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        //terminator
        if (preLeft > preRight || inLeft > inRight)return null;

        //process and drill down
        int rootVal = preorder[preLeft];
        int pivot = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = treeBuilder(preorder, inorder, preLeft + 1, pivot - inLeft + preLeft, inLeft, pivot - 1);
        root.right = treeBuilder(preorder, inorder, pivot - inLeft + preLeft + 1, preRight, pivot + 1, inRight);
        return root;
    }
}
