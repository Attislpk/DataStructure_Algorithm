package 二叉树与递归;

public class _235_二叉搜索树的最近公共祖先 {
}


class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        assert p != null && q != null;

        if (root == null) return null;

        //pq位于同侧和pq位于异侧，位于异侧时直接返回根节点即可
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);  //return 在左子树上的根节点
        }

        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q); //return 在右子树上的根节点
        }
        //直到递归到pq异侧时的上一层/或者pq任意一个是另一个的祖先节点
        return root;
    }
}