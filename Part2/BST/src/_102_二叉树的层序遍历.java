import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //对每一层的元素单独存储
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                count --;
            }
            res.add(list);
        }
        return res;
    }
}
