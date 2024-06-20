class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.links[idx] == null) {
                temp.links[idx] = new Trie();
            }
            temp = temp.links[idx];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Trie temp = root;
        return search(word, temp);
    }

    public boolean search(String word, Trie tempRoot) {
        if (word.length() == 0)
            return tempRoot.isEnd;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int idx = 0; idx < 26; idx++) {
                    if (tempRoot.links[idx] != null) {
                        if (search(word.substring(i + 1), tempRoot.links[idx])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int idx = word.charAt(i) - 'a';
                if (tempRoot.links[idx] == null)
                    return false;
                tempRoot = tempRoot.links[idx];
            }
        }
        return tempRoot.isEnd;
    }
}

class Trie {
    Trie links[];
    boolean isEnd;

    Trie() {
        links = new Trie[26];
        isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */