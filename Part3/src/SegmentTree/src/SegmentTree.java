/**
 * 和普通的BST、堆相比，根节点的索引完全一致，只是节点中存储的值是一个区间而已，一个节点包括(索引、左区间、右区间)
 *
 * @param <E>
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merge; //组合一个融合器,没有采用implements的方式

    public SegmentTree(E[] arr, Merger<E> merge) {
        this.merge = merge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //返回区间[L,R]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //以treeIndex为根节点的区间[l,r]上查找区间[queryL,queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //边界条件
        if (queryL == l && queryR == r) {
            return tree[treeIndex]; //返回根节点
        }

        //递归查询左右子树
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) { //mid+1~r
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {//l~mid
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            //交叉区间
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merge.merge(leftResult, rightResult);
        }
    }

    //在treeIndex的根节点位置创建表示区间[l,r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //边界条件-->叶子节点
        if (l == r) {
            tree[treeIndex] = data[l]; //根节点区间长度为1,同时将data中的数据填入tree中
            return; //到达叶子节点，递归结束
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        //根节点的操作
        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    //对线段树中的某index的元素进行更新的操作(对叶子节点进行更新,不包括null的节点)
    public void set(int index, E e) {
        data[index] = e; //首先对数组进行更新
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("index is illegal!");
        }

        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        //边界条件(叶子节点)
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else { //index <= mid
            set(leftTreeIndex, l, mid, index, e);
        }
        //对上一层根节点的值进行更新
        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal!");
        } else
            return data[index];
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }
            if (i != tree.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
