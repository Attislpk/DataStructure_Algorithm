/**
 * 为链表添加尾节点，实现队列
 * 链表头为队首，负责出队，链表尾为队尾负责入队
 */
public class LinkedListQueue<E> implements Queue<E> {


    //内部节点类的字段及方法
    private class Node<E>{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null);
        }

        public String toString(){
            return e.toString();
        }
    }

    //LinkedListQueue的字段及方法
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
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

    //从tail入队的复杂度为O(1)
    @Override
    public void enqueue(E e) {
        if (isEmpty()){
            //如果队列为空
            tail = new Node<>(e);
            head = tail;
        }else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    //从front出队的复杂度为O(1)
    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        //如果原来的queue中只有一个元素
        if (head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue front:");
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL tail");
        return res.toString();
    }
}
