public class MinHeap<E extends Comparable<E>> {
    //二叉堆的底层用Array来实现, 创建一个Array的引用called data
    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity); //data引用指向一个Array对象
    }

    public MinHeap() {
        data = new Array<>();  //data引用指向一个Array对象
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
    }

    //找出叶子节点的父节点进行siftDown操作
    public void Heapify(E[] arr) {
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //查看堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回二叉堆中某索引表示节点的父节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index=0 doesn't have a parent!");
        }
        return (index - 1) / 2;
    }

    //返回二叉堆中某索引表示节点的左子树节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回二叉堆中某索引表示节点的右子树节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        //传入最后一个元素的索引
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) > 0) {
            data.swap(parent(index), index);
            index = parent(index);
        }
    }

    E findMin() {
        return data.get(0);
    }

    //从堆中取出最大的元素(index = 0)
    public E extractMin() {
        E ret = findMin();
        //将最大元素和最小元素进行交换
        data.swap(0, data.getSize() - 1);
        //移除array中最后一个元素
        data.removeLast();

        //index = 0的元素下沉
        siftDown(0);
        return ret;
    }

    private void siftDown(int index) {   //index指向的是要下沉元素的索引
        //首先找出index索引左右子树的最大值
        //如果index索引的元素还有左子树，则还可以继续下沉判断
        while (leftChild(index) < data.getSize()) {
            //j 引用默认指向左孩子
            int j = leftChild(index);   //j引用指向的是左右孩子中的最小值
            //如果右子树也存在,且右子树的值小于左子树
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) > 0) {
                j = rightChild(index); //j的引用指向右孩子
                //data[j]是leftChildren和rightChildren中的最小值
            }
            if (data.get(index).compareTo(data.get(j)) <= 0) {
                break;
            }
            data.swap(index, j); //交换的是索引对应的元素!
            index = j; //交换完毕后index(要下沉元素的索引)指向原来的索引j, 继续进行判断
        }
    }

    //取出二叉堆中的最大元素，并替换成元素e
    public E replace(E e) {

        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;

    }
}
