public class Array<E> {
    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    //指定容量的构造方法
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造
    public Array() {
        this(DEFAULT_CAPACITY); //如果DEFAULT_CAPACITY非静态，则无法在此处调用，因为非静态成员属性必须通过对象才能调用，因此此处用static修饰使其称为类变量
    }

    public Array(E[] arr){
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组中任意位置添加元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is illegal");
        }

        //进行数组大小判断,如果size == data.length， size代表连续元素的末尾位置,说明数组已经满了，需要进行动态扩容
        if (size == data.length) {
            resize(2 * size);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i]; //完成数据迁移
        }
        data[index] = e;
        size++;
    }

    //向数组最后添加元素, 数组现有的索引是0~(size-1)
    public void addLast(E e) {
        add(size, e);
    }

    //向数组第一个位置添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //获取某个索引位置的元素
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    //修改某个索引位置的元素
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
    }

    //判断数组中是否包含某元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //判断数组中某元素的索引位置
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除数组中的某索引元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E ret = get(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //避免复杂度震荡，且确保数组的最小容量为10
        if (size == data.length / 4 && data.length / 2 > DEFAULT_CAPACITY) {
            resize(data.length / 2);
        }
        return ret;
    }

    //删除数组中的第一个元素
    public E removeFirst() {
        return remove(0);
    }

    //删除数组中的最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    //删除数组中的指定元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1){
            remove(index);
        }else
            throw new IllegalArgumentException("Element not found!");
    }

    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];//数据迁移
        }
        data = newData; //引用指向
    }

    //交换数组中两个索引对应的元素位置
    public void swap(int i, int j){
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d, capacity = %d\n", size, data.length)).append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        return res.append("]").toString();
    }
}