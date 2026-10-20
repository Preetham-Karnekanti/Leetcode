class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node dummy = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (dummy.arr[idx] == null)
                dummy.arr[idx] = new Node();
            dummy = dummy.arr[idx];
        }
        dummy.isEnd = true;
    }

    public boolean search(String word) {
        Node dummy = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (dummy.arr[idx] == null)
                return false;
            dummy = dummy.arr[idx];
        }
        return dummy.isEnd;
    }

    public boolean startsWith(String word) {
        Node dummy = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (dummy.arr[idx] == null)
                return false;
            dummy = dummy.arr[idx];
        }
        return true;
    }
}

class Node {
    Node arr[];
    boolean isEnd;

    Node() {
        arr = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */