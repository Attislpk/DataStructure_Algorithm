import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {
}
//左-根-右
class Solution94 {

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        return inorderTraversal(root, list);

    }
    private List<Integer> inorderTraversal(TreeNode root, List list){
        //边界条件
        if (root == null) return list;
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
        return list;
    }

    //迭代，利用stack，首先将左链全部添加到stack中，然后逐渐判断出栈即可
    public List<Integer> inorderTraversalNR(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //此处的root!=null 只用作第一次判断
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}