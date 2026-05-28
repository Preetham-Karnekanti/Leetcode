class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie root = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], i);
        }
        int ans[] = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i], root);
        }
        return ans;
    }

    public int search(String word, Trie root) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] != null)
                root = root.arr[idx];
            else
                break;
        }
        return root.idx;
    }

    public void insert(Trie root, String word, int idx) {
        if (root.minLen > word.length()) {
            root.minLen = word.length();
            root.idx = idx;
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            int k = word.charAt(i) - 'a';
            if (root.arr[k] == null)
                root.arr[k] = new Trie();
            root = root.arr[k];
            if (root.minLen > word.length()) {
                root.minLen = word.length();
                root.idx = idx;
            }
        }
    }
}

class Trie {
    int idx;
    int minLen;
    Trie arr[];

    Trie() {
        idx = -1;
        minLen = Integer.MAX_VALUE;
        arr = new Trie[26];
    }
}