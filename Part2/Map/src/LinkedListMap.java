public class LinkedListMap<K,V> implements Map<K,V>{
    //内部节点类
    private class Node {
        private K key;
        private V value;
        private Node next;

        //带三个参数的构造方法
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        //其他构造方法
        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyNode; //虚拟头结点
    private int size;

    public LinkedListMap() {
        dummyNode = new Node();
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

    public Node getNode(K key) {
        Node cur = dummyNode.next; //头结点
        while (cur.next != null) {
            if (cur.key == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            //map中还没有该key,直接添加到链表头部O(1)
            dummyNode.next = new Node(key, value, dummyNode.next);
            size++;
        } else {
            //已经存在该key则更新value
            node.value = value;
        }
    }


    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        } else {
            node.value = newValue;
        }
    }

    @Override
    public V remove(K key) {
        //首先找到该节点的前一个节点
        Node pre = dummyNode; //虚拟头结点
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                break; //找到该节点则退出循环
            }
            //继续循环
            pre = pre.next;
        }

        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next; //delNode的前一个节点与其断开
            delNode.next = null; //delNode与后一个节点断开
            size--;
            return delNode.value;
        }
        return null; //没有找到该节点
    }

}


