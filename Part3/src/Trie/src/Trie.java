import java.util.Map;
import java.util.TreeMap;

public class Trie {

    private class Node {
        private boolean isWord; //当前Node是否是word的结尾
        private TreeMap<Character, Node> next; // 通过Character获取到达下一个Node的映射, 每一个节点Node都可以通过Map获取达到下一个Node的映射

        public Node(boolean isWord) {
            this.isWord = isWord;
            //next对应的是一个Map，K-V的映射
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    //向Trie中添加单词
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                //next中还没有存储相应的char,node键值对
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            //cur节点中没有存储过该单词
            cur.isWord = true;
            size++;
        }
    }

    //查询单词
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.next.get(c)==null){
                //next中不包含该键值对
                return false;
            }else {
                cur = cur.next.get(c);
            }
        }
        return cur.isWord;
    }

    //判断trie中是否有相应的前缀prefix
    public boolean startWith(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
