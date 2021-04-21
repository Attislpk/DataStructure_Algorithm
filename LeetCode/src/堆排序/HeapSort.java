package 堆排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class MaxHeap <E extends Comparable<E>> {
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
}

class TestHeap {
    private TestHeap() {};


    static <E extends Comparable<E>> void sort(E[] arr, boolean hepify) {
        MaxHeap<E> maxHeap;
        if (hepify) {
            maxHeap = new MaxHeap<>(arr);
        } else {
            maxHeap = new MaxHeap<>(arr.length);
            for (int i = 0; i < arr.length; i++) {
                maxHeap.add(arr[i]);
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}


