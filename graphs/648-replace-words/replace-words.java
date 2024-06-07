class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String str : dictionary)
            insert(root, str);
        String words[] = sentence.split(" ");
        String ans = "";
        for (String str : words) {
            ans += search(root, str);
            ans += " ";
        }
        return ans.strip();
    }

    public void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] == null)
                root.arr[idx] = new Trie();
            root = root.arr[idx];
        }
        root.isLast = true;
    }

    public String search(Trie root, String word) {
        String temp = "";
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.arr[idx] == null)
                return word;
            temp += word.charAt(i);
            root = root.arr[idx];
            if (root.isLast)
                return temp;
        }
        return word;
    }
}

class Trie {
    Trie arr[];
    boolean isLast;

    Trie() {
        this.arr = new Trie[26];
        isLast = false;
    }
}