class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], root);
        }
        return search(pref, root);
    }

    public int search(String word, Trie root) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] == null)
                return 0;
            root = root.arr[idx];
        }

        return root.count;
    }

    public void insert(String word, Trie root) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] == null)
                root.arr[idx] = new Trie();
            root = root.arr[idx];
            root.count++;
        }
    }
}

class Trie {
    Trie[] arr;
    int count;

    Trie() {
        arr = new Trie[26];
        count = 0;
    }
}