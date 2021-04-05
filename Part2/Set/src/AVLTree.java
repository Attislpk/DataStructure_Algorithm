import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {

    //内部节点类
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    //获取节点的高度
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    //获取节点的平衡因子
    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //判断该二叉树是否是BST
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        //对该树进行中序遍历,将遍历结果存放到keys中
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node root, ArrayList<K> keys) {
        //边界条件
        if (root == null) {
            return;
        }
        //递归
        inOrder(root.left, keys);
        keys.add(root.key);
        inOrder(root.right, keys);
    }


    //判断该树是否是平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(root);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
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
            root.right = add(root.right, key, value); //指针指向
        } else //key.compareTo(root.key) = 0
            root.value = value; //更新value
        //更新height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        //计算平衡因子
        int balanceFactor = getBalanceFactor(root);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbanlanced :" + balanceFactor);
        }

        //LL root的bf>1，且root的左子树的bf>=0（root左子树的左子树高度>=右子树）
        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0) {
            //如果不平衡，且该树是左斜的,则进行右旋转
            return rightRotate(root);
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(root.right) <= 0) {
            //如果不平衡，且该树是右斜的，则进行坐旋转
            return leftRotate(root);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            //先进行左旋转，再进行右旋转
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(root.right) > 0) {
            //先进行右旋转，再进行左旋转
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }


        return root;
    }

    //右旋转,传入旋转前的根节点，并返回旋转后的根节点
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;

        //先更新y再更新x
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    //左旋转,传入旋转前的根节点，并返回旋转后的根节点
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        //先更新y再更新x
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    //返回以root为根的节点的BSTMap中，key所在的节点
    private Node getNode(Node root, K key) {
        //边界条件
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            return root; //递归退出条件
        } else if (key.compareTo(root.key) < 0) {
            return getNode(root.left, key);
        } else
            return getNode(root.right, key);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
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


    //删除BST中的任意元素, 在add和remove中需要对平衡性进行维护
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return root.value;
        }
        return null;

    }

    //删除BST中的元素并返回删除元素后BST的根节点
    private Node remove(Node root, K key) {
        //边界条件
        if (root == null) {
            return null; //没找到
        }

        Node retNode; //不能直接将根节点进行返回，需要确保平衡性后再返回

        //首先递归查找该元素,返回该元素所在子树的根节点
        if (key.compareTo(root.key) < 0) {
            retNode = remove(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            retNode = remove(root.right, key);
        }
        //e == root.e, 删除该节点
        else {
            //待删除节点左子树为空
            if (root.left == null) {
                Node rightNode = root.right;//暂存
                root.right = null;//断开
                size--;
                retNode = rightNode;//返回作为新的根节点
            } else if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;//断开
                size--;
                retNode = leftNode; //返回作为新的根节点
            } else {
                //如果左右子树均不为空，则根节点为原根节点的前驱或后继节点，此处选择后继节点
                Node successor = minimum(root.right);
                successor.right = remove(root.right,successor.key); //右子树中后继结点的key
                successor.left = root.left;
                root.left = root.right = null;
                retNode =  successor;
            }
        }

        if (retNode == null){
            return null;
        }

        //更新height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            //如果不平衡，且该树是左斜的,则进行右旋转
            return rightRotate(retNode);
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            //如果不平衡，且该树是右斜的，则进行坐旋转
            return leftRotate(retNode);
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            //先进行左旋转，再进行右旋转
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            //先进行右旋转，再进行左旋转
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }
}
