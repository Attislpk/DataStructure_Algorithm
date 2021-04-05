//UninonFind3 第三版
public class UnionFind3 implements UF{
    int[] parent; //存放父节点的索引
    int[] arrow; //存放每个Root节点被子节点指向的个数
    public UnionFind3(int size){
        parent = new int[size];
        arrow = new int[size];
        for (int i = 0; i < size; i++){
            parent[i] = i;
            arrow[i] = 1;
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
        if (arrow[pRoot] > arrow[qRoot]){ //指向pRoot的节点更多, parent[qRoot]=pRoot; 谁更大就指向谁
            parent[qRoot] = pRoot;
            arrow[pRoot] += arrow[qRoot];
        }else {
            parent[pRoot] = qRoot;
            arrow[qRoot] += arrow[pRoot];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
