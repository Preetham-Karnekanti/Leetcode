class Solution {
    int n;
    HashMap<String, ArrayList<String>> wordsWithPrefix;

    public List<List<String>> wordSquares(String[] words) {
        wordsWithPrefix = new HashMap<>();
        getWordsWithPrefix(words);
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

    public void getWordsWithPrefix(String words[]) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i + 1);
                wordsWithPrefix.putIfAbsent(prefix, new ArrayList<>());
                wordsWithPrefix.get(prefix).add(word);
            }
        }
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

        for (String word : wordsWithPrefix.getOrDefault(prefix.toString(), new ArrayList<>())) {
            wordSquares.add(word);
            backtrack(step + 1, wordSquares, words, answer);
            wordSquares.remove(wordSquares.size() - 1);
        }
    }
}