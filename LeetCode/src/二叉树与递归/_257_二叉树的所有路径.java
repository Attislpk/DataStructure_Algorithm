package 二叉树与递归;

import java.util.ArrayList;
import java.util.List;

public class _257_二叉树的所有路径 {
}


class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        //既然访问了root的left和right属性，就要确保root不为空
        if (root == null) return res;

        //递归终止条件
        if (root.left == null && root.right == null){
            res.add(String.valueOf(root.val));
            return res; //还需要将该结果返回给上层
        }

        //对left和right分别进行递归
        List<String> left = binaryTreePaths(root.left);
        for (String s:left){
            //当前节点的value+当前节点的左子节点的value
            res.add(root.val + "->" + s);
        }
        List<String> right = binaryTreePaths(root.right);
        for (String s: right){
            res.add(root.val + "->" + s);
        }
        return res;
    }
}