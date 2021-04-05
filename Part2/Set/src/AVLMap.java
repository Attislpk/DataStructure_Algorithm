public class AVLMap<K extends Comparable<K>, V> implements Map<K,V> {

    //底层是AVL树
    private AVLTree<K,V> avlTree;

    @Override
    public V remove(K key) {
        return avlTree.get(key);
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key,value);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avlTree.set(key,newValue);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
