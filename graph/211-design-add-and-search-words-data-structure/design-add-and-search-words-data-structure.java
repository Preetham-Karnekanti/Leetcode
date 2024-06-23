class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Trie();
            temp = temp.arr[idx];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Trie temp = root;
        return helper(word, temp);
    }

    public boolean helper(String word, Trie temp) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int k = 0; k < 26; k++) {
                    if (temp.arr[k] != null)
                        if (helper(word.substring(i + 1), temp.arr[k]))
                            return true;
                }
                return false;
            } else {
                int idx = word.charAt(i) - 'a';
                if (temp.arr[idx] == null)
                    return false;
                temp = temp.arr[idx];
            }
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */