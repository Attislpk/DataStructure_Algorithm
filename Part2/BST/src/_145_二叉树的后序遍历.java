import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145_二叉树的后序遍历 {
}


class Solution145{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        return postorderTraversal(root,res);
    }

    private List postorderTraversal(TreeNode root, List res){
        if (root == null) return res;
        postorderTraversal(root.left,res);
        postorderTraversal(root.right,res);
        res.add(root.val);
        return res;
    }


    public List<Integer> postorderTraversalNR(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //先搂一眼栈顶元素
            cur = stack.peek();
            //如果根节点的右子节点为空或者已经被访问过了，则说明右子节点已经被遍历并出栈了
            if (cur.right == null || cur.right == pre){
                res.add(cur.val);
                stack.pop();
                pre = cur;
                cur = null;
            }else {
                //先于根节点访问右子节点
                cur = cur.right;
            }
        }
        return res;
    }
}
