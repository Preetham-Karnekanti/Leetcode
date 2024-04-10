class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String word : dictionary) {
            insert(word, root);
        }
        String[] sen = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sen.length; i++) {
            sb.append(search(sen[i], root));
            if (i != sen.length - 1)
                sb.append(" ");
        }

        return sb.toString();
    }

    public void insert(String word, Trie root) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] == null)
                root.arr[idx] = new Trie();
            root = root.arr[idx];
        }
        root.isLeaf = true;
    }

    public String search(String word, Trie root) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            sb.append(word.charAt(i));
            if (root.arr[idx] == null)
                return word;
            root = root.arr[idx];
            if (root.isLeaf)
                return sb.toString();
        }
        return word;
    }
}

class Trie {
    Trie arr[];
    boolean isLeaf;

    Trie() {
        arr = new Trie[26];
        isLeaf = false;
    }
}