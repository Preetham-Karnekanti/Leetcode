class Solution {

    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i], root);
        }

        String ans = "";
        int c[] = count(root);
        while (c[0] == 1 && root.isLeaf == false) {
            ans = ans + (char) (c[1] + 97);
            root = root.arr[c[1]];
            c = count(root);
        }
        return ans;
    }

    public int[] count(Trie root) {
        int count = 0;
        int idx = -1;
        for (int i = 0; i < 26; i++) {
            if (root.arr[i] != null) {
                count++;
                idx = i;
            }
        }
        return new int[] { count, idx };

    }

    public void insert(String str, Trie root) {
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (root.arr[idx] == null)
                root.arr[idx] = new Trie();
            root = root.arr[idx];
        }
        root.isLeaf = true;
    }
}

class Trie {
    Trie arr[] = new Trie[26];
    boolean isLeaf;

    Trie() {
        Arrays.fill(arr, null);
        isLeaf = false;
    }
}