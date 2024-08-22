class StreamChecker {
    Trie root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        root = new Trie();
        sb = new StringBuilder();
        for (String word : words)
            addToTrie(word);
    }

    public void addToTrie(String word) {
        Trie temp = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Trie();
            temp = temp.arr[idx];
        }
        temp.isEnd = true;
    }

    public boolean query(char letter) {
        Trie temp = root;
        sb.append(letter);
        for (int i = sb.length() - 1; i >= 0; i--) {
            int idx = sb.charAt(i) - 'a';
            if (temp.isEnd)
                return true;
            if (temp.arr[idx] == null)
                return false;
            temp = temp.arr[idx];
        }
        return temp.isEnd;
    }
}

class Trie {
    Trie arr[];
    boolean isEnd;

    Trie() {
        arr = new Trie[26];
        isEnd = false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */