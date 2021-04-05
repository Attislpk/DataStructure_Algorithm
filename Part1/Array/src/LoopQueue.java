/**
 * 本类中的%data.length操作是为了消除周期性，因此只需要考虑原本的逻辑，在原逻辑上添加()%data.length就可以消除循环带来的影响
 * @param <E>
 */

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    //空的循环队列front和tail指向的位置相同
    public boolean isEmpty() {
        return front == tail;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        //队列已经满了
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        //维护tail和size
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        //如果队列为空
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue cannot be empty!");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //缩容操作
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        //数据迁移
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length]; //i+front的偏移量
        }
        data = newData;
        front = 0; //newData中元素的front重新从0开始
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d  ",size,getCapacity()));
        res.append("Front [");
        for (int i = front; i != tail; i = (i +1)%data.length){
            res.append(data[i]);
            if ((i+1)% data.length != tail ){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
