class Solution {
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for (String str : words)
            t.insert(str);
        String ans = "";
        for (String str : words) {
            if (str.length() >= ans.length() && t.search(str)) {
                if (str.length() > ans.length() || ans.compareTo(str) > 0)
                    ans = str;
            }
        }
        return ans;
    }
}

class Trie {
    Node root;

    class Node {
        Node arr[];
        boolean isEnd;

        Node() {
            arr = new Node[26];
            isEnd = false;
        }
    }

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Node();
            temp = temp.arr[idx];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx].isEnd == false)
                return false;
            temp = temp.arr[idx];
        }
        return true;
    }
}