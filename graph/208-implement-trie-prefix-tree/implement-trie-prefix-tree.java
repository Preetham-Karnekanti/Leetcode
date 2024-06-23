class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Node();
            temp = temp.arr[idx];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                return false;
            temp = temp.arr[idx];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                return false;
            temp = temp.arr[idx];
        }
        return true;
    }
}

class Node {
    Node arr[];
    boolean isEnd;

    Node() {
        arr = new Node[26];
        isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */