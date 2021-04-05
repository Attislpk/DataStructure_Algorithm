public class UnionFind1 implements UF{
    int[] id;

    public UnionFind1(int size){
        id = new int[size];
        for (int i = 0; i < size; i++){
            id[i] = i;
        }
    }


    @Override
    public int getSize() {
        return id.length;
    }

    //获取某元素的id
    private int find(int p){
        if (p < 0 || p >= id.length){
            throw new IllegalArgumentException("index is illegal");
        }
        return id[p];
    }

    //union的目的就是让p和q的id相同，同样，p和q所在的集合的id也需要相同   O(n)
    @Override
    public void unionElements(int p, int q) {
        if (find(p) == find(q)){
            return;
        }
        for (int i = 0; i < id.length; i++){
            if (id[i] == find(p)){
                id[i] = find(q); //将pID替换为qID
            }
        }
    }

    //quick find  O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
