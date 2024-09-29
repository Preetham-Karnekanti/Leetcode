class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tempRoot.children[idx] == null)
                tempRoot.children[idx] = new Node();
            tempRoot = tempRoot.children[idx];
            tempRoot.startCount++;
        }
        tempRoot.endCount++;
    }

    public int countWordsEqualTo(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tempRoot.children[idx] == null)
                return 0;
            tempRoot = tempRoot.children[idx];
        }
        return tempRoot.endCount;
    }

    public int countWordsStartingWith(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tempRoot.children[idx] == null)
                return 0;
            tempRoot = tempRoot.children[idx];
        }
        return tempRoot.startCount;
    }

    public void erase(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            tempRoot = tempRoot.children[idx];
            tempRoot.startCount--;
        }
        tempRoot.endCount--;
    }
}

class Node {
    Node children[];
    int startCount;
    int endCount;

    Node() {
        children = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */