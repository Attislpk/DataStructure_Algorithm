package HashCode;

import java.util.TreeMap;

/**
 *
 */
public class HashTable<K, V> {

    private final int[] capacity = {61, 83, 113, 151, 211, 281, 379, 509, 683, 911,
            1217, 1627, 2179, 2909, 3881, 6907, 9209};

    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private int capacityIndex = 0;
    private TreeMap<K, V>[] hashTable; //TreeMap数组， 每一个索引对应一个TreeMap
    private int size;
    private int M; //素数，对应hashTable索引范围 0~M-1，对应数组的大小

    public HashTable() {
        this.M = capacity[capacityIndex];
        size = 0;
        //初始化HashTable
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>(); //hashTable中的每一个索引都对应一个TreeMap
        }
    }


    //hash函数
    private int hash(K key) {
        //获取key的hashCode值，与0x7fffffff相与确保hashCode值为正，对M取模，将其放入对应hashTable索引对应的TreeMap中
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    //添加元素
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)]; //hashTable中的每一个索引都对应一个TreeMap
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            //动态大小调整N/M > UPPER_TOL
            if (size > UPPER_TOL * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                //扩容
                resize(capacity[capacityIndex]);
            }
        }
    }

    //移除元素
    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
        }
        if (size < LOWER_TOL * M && capacityIndex - 1 >= 0) {
            capacityIndex--;
            resize(capacity[capacityIndex]);
        }
        return ret;
    }

    //修改元素
    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist");
        } else {
            map.put(key, value);
        }
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        //初始化
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        //数据迁移
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) { //循环次数为oldM次
            TreeMap<K, V> map = hashTable[i]; //将hashtable中的每个索引对应的TreeMap取出
            for (K key : map.keySet()) { //hash(key)和M相关,将M更新为newM
                newHashTable[hash(key)].put(key, map.get(key)); //根据key的hash值，将k，v存入对应的map中
            }
        }
        this.hashTable = newHashTable; //更新引用
    }
}
