public class BSTSet<E extends Comparable<E>> implements Set<E>{

    //Set的底层实现是BST
    //关联BST
    private BST<E> bst;

    public BSTSet(){
        bst = new BST<E>();
    }


    //通过底层的BST可以实现去重操作
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
