public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    //内部节点类
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    //向BSTMap中添加新元素(key, value)
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //向以root为根的BSTMap中添加元素(key, value)，递归算法
    //返回插入新节点后BSTMap的根
    private Node add(Node root, K key, V value) {
        if (root == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(root.key) < 0) {
            root.left = add(root.left, key, value); //指针指向
        } else if (key.compareTo(root.key) > 0) {
            root.right = add(root.right, key,value); //指针指向
        }else //key.compareTo(root.key) = 0
            root.value = value; //更新value
        return root;
    }

    //返回以root为根的节点的BSTMap中，key所在的节点
    private Node getNode(Node root, K key) {
        //边界条件
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) == 0){
            return root; //递归退出条件
        }else if (key.compareTo(root.key) < 0){
            return getNode(root.left, key);
        }else
            return getNode(root.right, key);
    }

    @Override
    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key){
        Node node = getNode(root, key);
        return node != null? node.value : null;
    }

    @Override
    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException( key + "doesn't exist!");
        }
        node.value = newValue;
    }

    private Node minimum(Node root) {
        //递归边界条件
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
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


    //删除BST中的任意元素
    public V remove(K key){
        Node node = getNode(root, key);
        if (node!= null){
            root = remove(root, key);
            return root.value;
        }
        return null;

    }
    //删除BST中的元素并返回删除元素后BST的根节点
    private Node remove(Node root, K key){
        //边界条件
        if (root == null){
            return null; //没找到
        }

        //首先递归查找该元素,返回该元素所在子树的根节点
        if (key.compareTo(root.key) < 0){
            root.left = remove(root.left,key);
        }else if (key.compareTo(root.key) > 0){
            root.right = remove(root.right,key);
        }
        //e == root.e, 删除该节点
        else {
            //待删除节点左子树为空
            if(root.left == null){
                Node rightNode = root.right;//暂存
                root.right = null;//断开
                size--;
                return rightNode;//返回作为新的根节点
            }
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


}
