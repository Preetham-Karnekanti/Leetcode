class AutocompleteSystem {

    Trie root, curNode;
    StringBuilder currentInput;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        curNode = root;
        currentInput = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
    }

    public void addToTrie(String word, int count) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i);
            if (temp.children[idx] == null)
                temp.children[idx] = new Trie();
            temp = temp.children[idx];
            temp.sentences.put(word, temp.sentences.getOrDefault(word, 0) + count);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            addToTrie(currentInput.toString(), 1);
            currentInput.setLength(0);
            curNode = root;
            return new ArrayList<>();
        }
        currentInput.append(c);
        if (curNode == null || curNode.children[c] == null){
            curNode = null;
            return new ArrayList<>();
        }
        curNode = curNode.children[c];
        List<String> sentences = new ArrayList<>(curNode.sentences.keySet());
        Collections.sort(sentences, (a, b) -> {
            int timesA = curNode.sentences.get(a);
            int timesB = curNode.sentences.get(b);
            if (timesA != timesB)
                return timesB - timesA;
            return a.compareTo(b);
        });
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sentences.size()); i++) {
            ans.add(sentences.get(i));
        }
        return ans;
    }
}

class Trie {
    Trie children[];
    Map<String, Integer> sentences;

    Trie() {
        children = new Trie[256];
        sentences = new HashMap<>();
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */