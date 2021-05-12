package 堆排序;

import java.util.ArrayList;
import java.util.Arrays;

class MaxHeap <E extends Comparable<E>> {
    //大顶堆的实现，底层基于动态数组实现
    private final ArrayList<E> data;

    public MaxHeap(int size) {
        data = new ArrayList<>(size);
    }

    //构造堆的方法1：已知数组，根据数组创建堆,依次执行siftDown操作，直接避开所有的叶子节点
    public MaxHeap(E[] arr) {
        data = new ArrayList<E>(Arrays.asList(arr));
        //找到最后一个叶子节点的parent，然后依次向上执行siftUp操作
        for (int i = parent(data.size() - 1); i >=0; i--) {
            siftDown(i);
        }
    }

    //三个基本方法
    private int parent(int k) {return (k - 1) / 2;};
    private int leftChild(int k) {return (2 * k) + 1;};
    private int rightChild(int k) {return (2 * k) + 2;};

    //构建堆的方法2：一个一个向堆中添加元素，每一次添加元素后都执行siftUp操作
    public void add (E e) {
        data.add(e);
        //对最后一个元素进行siftUp
        siftUp(data.size() - 1);
    }

    //子节点元素的上浮操作
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            swap(data, k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {return data.get(0);};
    public E extractMax() {
        E max = findMax();
        swap(data, 0, data.size() - 1);
        siftDown(0);
        return max;
    }

    private void siftDown(int k) {
        //判断k是否有左子节点
        while (leftChild(k) < data.size()) {
            int maxIndex = leftChild(k);
            //如果右子节点也存在，则比较大小
            if (leftChild(k) + 1 < data.size() && data.get(rightChild(k)).compareTo(data.get(leftChild(k))) > 0) {
                maxIndex = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(maxIndex)) >= 0) return;
            swap(data, k, maxIndex);
            k = maxIndex;
        }
    }

    private void  swap(ArrayList<E> arr, int i, int j) {
        E temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    /**
    private ArrayList<E> data;
    public MaxHeap() {
        data = new ArrayList<>();
    }
    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new ArrayList<>(Arrays.asList(arr));
        //将一个数组变成堆
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    private int rightChild (int index) {
        return 2 * index + 2;
    }

    //如果一个一个数字传入，只能使用add方法
    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    public E findMax() {
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        swap(data, 0, data.size() - 1);
        data.remove(data.size() - 1);

        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.size()) {
            int maxIndex = leftChild(k);
            if (maxIndex + 1 < data.size() && data.get(leftChild(k)).compareTo(data.get(rightChild(k))) < 0) {
                maxIndex = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(maxIndex)) >= 0) break;
            swap(data, k, maxIndex);
            k = maxIndex; //对应的在数组中的位置变成了maxIndex
        }
    }

    private void siftUp(int k) {
        while (data.get(k).compareTo(data.get(parent(k))) > 0) {
            swap(data, k, parent(k));
            k = parent(k);//对应的在数组中的位置变成了maxIndex
        }
    }

    private  void swap(ArrayList<E> data, int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
     */
}



