 interface MyMap<K,V> {

    V remove(K key);
    void add(K key, V value);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();


}
