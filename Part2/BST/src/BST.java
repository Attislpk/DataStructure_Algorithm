import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树BST， 泛型， 二分搜索树中存储的元素需要满足可比较性，因此E需要继承Comparable接口
 *
 * @param <E>
 */

public class BST<E extends Comparable<E>> {

    /**
     * 内部类--->节点类
     */
    private class Node {
        private E e;
        private Node left;
        private Node right;

        //节点的构造方法
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    //对BST中的元素进行定义
    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向BST中添加元素, 传入BST的根节点和需要添加的元素e，返回添加元素后BST的根节点node
    public void add(E e) {
        //该add方法中封装的下一层的private add方法
        root = add(root, e); //关联BST
    }
    //利用递归函数：构造递归函数：用于向BST中添加元素
    //1.终止条件：递归的root == null
    //2.递, 进行条件判断
    //3.归，返回添加元素后BST的根节点

    private Node add(Node node, E e) {
        //边界条件 向叶子节点下添加元素
        if (node == null) {
            size++;
            return new Node(e);
        }
        //拆分左右子树   递
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        //归 返回添加元素后BST的根节点node
        return node;
    }

    //查询BST中是否包含某个元素e
    public boolean contains(E e) {
        return contains(root,e);
    }

    //递归实现查询BST中是否包含某个元素
    //1.边界条件        2.递           3.归
    private boolean contains(Node root, E e) {
        //递归边界条件(找完整个二叉树后没有满足要求而导致的终止)
        if (root == null)
            return false;

        //递和归
        if (e.compareTo(root.e) == 0)
            return true; //递归终止条件(任意时刻满足要求导致的终止)
        else if ((e.compareTo(root.e) < 0))
            return contains(root.left, e); //继续递归
        else
            return contains(root.right, e); //继续递归
    }

    //BST的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        //1.边界条件
        if (root == null)
            return;

        //2.递归
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    //BST的前序遍历，非递归实现
    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.e);
            //先压入right，再压入left
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    //BST的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    //BST的后续遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    //BST的层序遍历
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    //BST查找最大和最小元素并返回
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node root) {
        //递归边界条件
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
    }

    //删除BST中的最小节点并返回
    public E removeMin() {
        E res = minimum();
        removeMin(root);
        return res;
    }

    //删除以node为根的BST中的最小节点
    //返回删除节点后新BST的根节点
    private Node removeMin(Node root) {
        //边界条件
        if (root.left == null) {
            Node rightNode = root.right; //将root.right暂存
            root.right = null; //将root.right断开
            size--;
            return rightNode; //返回root.right，此时和BST没有联系，需要在递归中接上
        }

        root.left = removeMin(root.left);  //将父节点root.left和root.right接上
        return root;
    }

    //删除BST中的最大节点并返回
    public E removeMax() {
        E res = maximum();
        removeMax(root);
        return res;
    }

    private Node removeMax(Node root) {

        //边界条件
        if (root.right == null) {
            Node leftNode = root.left; //暂存
            root.left = null;//断开
            size --;
            return leftNode; //返回
        }
        //递归
        root.right = removeMax(root.right); //建立与BST的关联
        return root;
    }

    //删除BST中的任意元素
    public void remove(E e){
        root = remove(root, e);
    }
    //删除BST中的元素并返回删除元素后BST的根节点
    private Node remove(Node root, E e){
        //边界条件
        if (root == null){
            return null; //没找到
        }

        //首先递归查找该元素,返回该元素所在子树的根节点
        if (e.compareTo(root.e) < 0){
             root.left = remove(root.left,e);
        }else if (e.compareTo(root.e) > 0){
             root.right = remove(root.right,e);
        }
        //e == root.e, 删除该节点
        else {
            //待删除节点左子树为空，右节点上位
            if(root.left == null){
                Node rightNode = root.right;//暂存
                root.right = null;//断开
                size--;
                return rightNode;//返回作为新的根节点
            }
            //左节点上位
            if (root.right == null){
                Node leftNode = root.left;
                root.left = null;//断开
                size--;
                return leftNode; //返回作为新的根节点
            }
            //如果左右子树均不为空，则根节点为原根节点的前驱或后继节点，此处选择后继节点
            Node successor = minimum(root.right);
            successor.right =  removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
        return root;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTstring(root, 0, res);
        return res.toString();
    }

    private void generateBSTstring(Node root, int depth, StringBuilder res) {
        if (root == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(root.e).append("\n");
        generateBSTstring(root.left, depth + 1, res);
        generateBSTstring(root.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
