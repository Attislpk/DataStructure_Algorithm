public class UnionFind2 implements UF{
    int[] parent; //存放父节点的索引

    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++){
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //从子节点遍历去寻找根节点
    private int find(int p){
        if (p < 0 || p >= parent.length){
            throw new IllegalArgumentException("index is illegal");
        }
        while (p != parent[p]){
            p = parent[p];// 向上继续遍历
        }
        return p; //p元素的根节点
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
