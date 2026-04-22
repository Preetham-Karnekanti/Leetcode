class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Trie root = new Trie();
        for (String w : dictionary)
            root.insert(root, w);

        List<String> res = new ArrayList<>();
        for (String q : queries) {
            if (root.search(root, q, 0, 0)) {
                res.add(q);
            }
        }
        return res;
    }
}

class Trie {
    Trie arr[];
    boolean isEnd;

    Trie() {
        arr = new Trie[26];
        isEnd = false;
    }

    void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (root.arr[ch] == null)
                root.arr[ch] = new Trie();
            root = root.arr[ch];
        }
        root.isEnd = true;
    }

    boolean search(Trie root, String word, int idx, int count) {
        if (count > 2 || root == null)
            return false;
        if (idx == word.length())
            return count <= 2 && root.isEnd;
        int i = word.charAt(idx) - 'a';
        if (root.arr[i] != null) {
            if (search(root.arr[i], word, idx + 1, count))
                return true;
        }
        for (int k = 0; k < 26; k++) {
            if (k == i)
                continue;
            if (root.arr[k] != null) {
                if (search(root.arr[k], word, idx + 1, count + 1))
                    return true;
            }
        }
        return false;
    }
}