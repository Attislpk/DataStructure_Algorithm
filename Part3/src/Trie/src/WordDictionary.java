//211. 添加与搜索单词 - 数据结构设计
//https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/

import java.util.TreeMap;

class WordDictionary {

    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this.isWord = false;
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);

        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node root, String word, int index) { //index代表word中第index个字母
        //边界条件
        if (index == word.length()) {
            return root.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            if (root.next.get(c) == null) {
                return false;
            }
            return match(root.next.get(c), word, index + 1);
        } else {
            //c = '.'
            for (char nextChar : root.next.keySet()) {
                return match(root.next.get(nextChar), word, index + 1);
            }
            return false;
        }
    }
}
