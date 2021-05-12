//UninonFind5 第五版：路径压缩的递归实现
public class UnionFind5 implements UF{
    int[] parent; //存放父节点的索引
    int[] rank; //rank[i]表示以i为根的集合所表示的树的层数
    public UnionFind5(int size){
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

    //从子节点遍历去寻找根节点, 从递归函数的语义出发，返回p节点的根节点
    private int findParent(int p){
        if (p < 0 || p >= parent.length){
            throw new IllegalArgumentException("index is illegal");
        }
       //路径压缩的递归实现
        //边界条件
        if (p != parent[p]){// 非根节点
            parent[p] = findParent(parent[p]);//路径压缩，递归实现
        }
        return parent[p]; //根节点 p = parent[p]
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = findParent(p);
        int qRoot = findParent(q);
        if (pRoot == qRoot){
            return;
        }
        if (rank[pRoot] > rank[qRoot]){ //合并完成之后不需要维护rank[]，因为rank[p]>rank[q]因此合并之后的rank[p]不变
            parent[qRoot] = pRoot; //qRoot的parent引用指向pRoot
        }else if (rank[qRoot] > rank[pRoot]){
            parent[pRoot] = qRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1; //如果二者的高度相同，则合并之后的高度会+1，画个图很好理解
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findParent(p) == findParent(q);
    }
}
