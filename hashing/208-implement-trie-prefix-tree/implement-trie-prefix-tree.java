class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tempRoot.arr[idx] == null)
                tempRoot.arr[idx] = new Node();
            tempRoot = tempRoot.arr[idx];
        }
        tempRoot.isLeaf = true;
    }

    public boolean search(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tempRoot.arr[idx] == null)
                return false;
            tempRoot = tempRoot.arr[idx];
        }
        return tempRoot.isLeaf;
    }

    public boolean startsWith(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tempRoot.arr[idx] == null)
                return false;
            tempRoot = tempRoot.arr[idx];
        }
        return true;
    }
}

class Node {
    Node[] arr;
    boolean isLeaf;

    Node() {
        arr = new Node[26];
        isLeaf = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */