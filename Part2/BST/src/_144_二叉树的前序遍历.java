import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_二叉树的前序遍历 {
}

//递归和迭代对二叉树进行前序遍历
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preorderTraversal(root,list);
    }

    private List<Integer> preorderTraversal(TreeNode root, List list){
        if (root == null) return list;

        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
        return list;
    }

//递归求解二叉树的遍历非常简单，下面使用迭代进行前序遍历，迭代进行前序遍历需要用到栈
    public List<Integer> preorderTraversalNR(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);

            //需要判断左右子树是否为空
            if (root.right != null){
                stack.push(root.right);
            }
           if (root.left != null){
               stack.push(root.left);
           }
        }
        return list;
    }
}

