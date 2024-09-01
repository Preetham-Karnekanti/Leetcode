class Solution {
    int n;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> answer = new ArrayList<>();
        List<String> wordSquares = new ArrayList<>();
        n = words[0].length();
        for (String word : words) {
            wordSquares.add(word);
            backtrack(1, wordSquares, words, answer);
            wordSquares.remove(wordSquares.size() - 1);
        }
        return answer;
    }

    public void backtrack(int step, List<String> wordSquares, String[] words, List<List<String>> answer) {
        if (step == n) {
            answer.add(new ArrayList<>(wordSquares));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }

        for (String word : getWordsWithPrefix(words, prefix.toString())) {
            wordSquares.add(word);
            backtrack(step + 1, wordSquares, words, answer);
            wordSquares.remove(wordSquares.size() - 1);
        }
    }

    public List<String> getWordsWithPrefix(String[] words, String prefix) {
        List<String> candidates = new ArrayList<>();
        for (String word : words) {
            if (word.startsWith(prefix))
                candidates.add(word);
        }
        return candidates;
    }
}