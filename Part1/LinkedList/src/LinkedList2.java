public class LinkedList2<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead; //采用虚拟头结点
    private int size;

    public LinkedList2() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //向链表头插入元素
    public void addFirst(E e) {
        add(0, e);
        size++;
    }

    //向链表中的任意位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        } else {
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                //0——index-1共index次
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    //向链表末尾添加元素
    public void addLast(E e) {
        add(size, e);
        size++;
    }

    //获取链表中的(0-based)位置处的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表头一个节点的元素
    public E getFirst() {
        return get(0);
    }

    //获取链表尾节点的元素
    public E getLast() {
        return get(size - 1);
    }

    //获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //修改链表中index处的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal!");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查询链表中是否包含某元素
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除链表中某个位置的元素
    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        return retNode.e;
    }

    //删除链表头的元素
    public E removeFirst() {
        return remove(0);
    }

    //删除链表尾的元素
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null){
//            res.append(cur+"->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
