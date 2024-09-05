class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        String ans = "";
        for (int i = 0; i < words.length; i++) {
            if (search(root, words[i])) {
                if (ans.length() < words[i].length() || ans.compareTo(words[i]) > 0) {
                    ans = words[i];
                }
            }
        }
        return ans;
    }

    public boolean search(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.children[idx] == null)
                return false;
            root = root.children[idx];
            if (root.isEnd == false)
                return false;
        }
        return root.isEnd;
    }

    public void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.children[idx] == null)
                root.children[idx] = new Trie();
            root = root.children[idx];
        }
        root.isEnd = true;
    }
}

class Trie {
    Trie children[];
    boolean isEnd;

    Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}