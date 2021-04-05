import java.util.Arrays;

public class ArrayList<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList (int newCapacity){
        elements = (E[])new Object[newCapacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E element) {
        if (size == elements.length) {
            resize (2 * size);
        }

        for (int i = size - 1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size ++;
    }
    //数组动态扩容
    private void resize(int newCapacity) {
        elements =  Arrays.copyOf(elements,newCapacity);
    }

    public void addFirst(E e) {
        add(0,e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }
        E e = get(index);
        for (int i = index; i < size - 1; i ++) {
            elements[i] = elements[i+1];
        }
        size --;

        //缩容判断
        if (size == elements.length / 4 && elements.length / 2 >= DEFAULT_CAPACITY) {
            resize(elements.length / 2);
        }

        return e;
    }

    //获取元素的索引
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) { //此处需要用equals
                return i;
            }
        }
        return -1;
    }

    //获取索引对应的元素
    public E get (int index) {
        if (index <0  || index > size - 1) {
            throw new IllegalArgumentException("index is illegal!");
        }
        return elements[index];
    }

    public void update(int index, E  e) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index is illegal!");
        }
        elements[index] = e;
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append(String.format("Array: size = %d, capacity = %d\n",size,elements.length)).append('[');
       for (int i = 0; i < size; i++) {
           res.append(elements[i]);
           if (i != size - 1) {
               res.append(',');
           }
       }
       return res.append(']').toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addLast(2);
        arrayList.addLast(3);
        arrayList.addLast(4);
        arrayList.addLast(5);
        arrayList.addFirst(1);
        arrayList.addLast(6);
        arrayList.addLast(7);
        arrayList.addLast(8);
        arrayList.addLast(9);
        arrayList.addFirst(0);
        arrayList.addLast(10);
        System.out.println(arrayList);
        arrayList.remove(5);
        arrayList.remove(1);
        arrayList.remove(1);
        arrayList.remove(1);
        arrayList.remove(1);
        arrayList.remove(1);
        arrayList.remove(1);
        arrayList.remove(1);
        System.out.println(arrayList);
    }
}
