public class AVLSet<K extends Comparable<K>,Object> implements Set<K> {

    //底层实现是AVL树
    private AVLTree<K,Object> avlTree;

    @Override
    public void add(K key) {
        avlTree.add(key, null);
    }

    @Override
    public void remove(K k) {
        avlTree.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return avlTree.contains(k);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
