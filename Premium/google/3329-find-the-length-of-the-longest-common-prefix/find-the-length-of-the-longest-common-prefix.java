class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int i = 0; i < arr1.length; i++) {
            insert(root, String.valueOf(arr1[i]));
        }
        int max = 0;
        for(int i = 0;i<arr2.length;i++){
            max = Math.max(max, search(root, String.valueOf(arr2[i])));
        }
        return max;
    }

    public int search(Trie root, String num) {
        int len = 0;
        for (int i = 0; i < num.length(); i++) {
            int idx = num.charAt(i) - '0';
            if (root.children[idx] == null)
                return len;
            len++;
            root = root.children[idx];
        }
        return len;
    }

    public void insert(Trie root, String num) {
        for (int i = 0; i < num.length(); i++) {
            int idx = num.charAt(i) - '0';
            if (root.children[idx] == null)
                root.children[idx] = new Trie();
            root = root.children[idx];
        }
    }
}

class Trie {
    Trie children[];

    Trie() {
        children = new Trie[10];
    }
}