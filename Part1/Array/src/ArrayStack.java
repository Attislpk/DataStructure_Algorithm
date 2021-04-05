public class ArrayStack<E> implements Stack<E> {

    //组合Array，底层是利用Array进行实现的
    private Array<E> array;

    //对Array进行初始化
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for (int i = 0; i < array.getSize(); i++){
            ret.append(array.get(i));
            if (i != array.getSize()-1){
                ret.append(", ");
            }
        }
        ret.append("] top");
        return ret.toString();
    }
}
