//UninonFind4 第四版
public class UnionFind4 implements UF{
    int[] parent; //存放父节点的索引
    int[] rank; //存放每个Root节点被子节点指向的个数
    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //从子节点遍历去寻找根节点   p = parent[p], 说明p节点为根节点
    private int find(int p){
        if (p < 0 || p >= parent.length){
            throw new IllegalArgumentException("index is illegal");
        }
        while (p != parent[p]){
            parent[p] = parent[parent[p]];//实现路径压缩
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
        if (rank[pRoot] > rank[qRoot]){ //pRoot的高度>qRoot的高度，因此parent[qRoot]指向pRoot
            parent[qRoot] = pRoot;
        }else if (rank[qRoot] > rank[pRoot]){
            parent[pRoot] = qRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
