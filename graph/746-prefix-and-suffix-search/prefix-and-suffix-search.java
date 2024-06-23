class WordFilter {
    Trie prefixRoot;
    Trie suffixRoot;
    HashMap<String, Integer> hm;

    public WordFilter(String[] words) {
        prefixRoot = new Trie();
        suffixRoot = new Trie();
        hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            insertPrefix(word);
            insertSuffix(word);
            hm.put(word, i);
        }
    }

    public void insertPrefix(String word) {
        Trie temp = prefixRoot;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Trie();
            temp = temp.arr[idx];
            temp.words.add(word);
        }
    }

    public void insertSuffix(String word) {
        Trie temp = suffixRoot;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Trie();
            temp = temp.arr[idx];
            temp.words.add(word);
        }
    }

    public int f(String pref, String suff) {
        HashSet<String> prefixWords = getPrefixWords(pref);
        if (prefixWords.size() == 0)
            return -1;
        HashSet<String> suffixWords = getSuffixWords(suff);
        if (suffixWords.size() == 0)
            return -1;
        int idx = -1;
        for (String word : prefixWords) {
            if (suffixWords.contains(word)) {
                idx = Math.max(idx, hm.get(word));
            }
        }
        return idx;
    }

    public HashSet<String> getPrefixWords(String word) {
        Trie temp = prefixRoot;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                return new HashSet<>();
            temp = temp.arr[idx];
        }
        return temp.words;
    }

    public HashSet<String> getSuffixWords(String word) {
        Trie temp = suffixRoot;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                return new HashSet<>();
            temp = temp.arr[idx];
        }
        return temp.words;
    }
}

class Trie {
    Trie arr[];
    HashSet<String> words;

    Trie() {
        arr = new Trie[26];
        words = new HashSet<>();
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */