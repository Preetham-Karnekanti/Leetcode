class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            insert(root, word);
        }
        int answer[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            answer[i] = search(words[i], root);
        }
        return answer;
    }

    public void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.children[idx] == null)
                root.children[idx] = new Trie();
            root = root.children[idx];
            root.count++;
        }
    }

    public int search(String word, Trie root) {
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            root = root.children[idx];
            answer += root.count;
        }
        return answer;
    }
}

class Trie {
    Trie children[];
    int count;

    Trie() {
        count = 0;
        children = new Trie[26];
    }
}