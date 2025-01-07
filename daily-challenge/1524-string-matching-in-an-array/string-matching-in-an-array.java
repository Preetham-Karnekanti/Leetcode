class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (isMatching(word, words))
                answer.add(word);
        }

        return answer;
    }

    private boolean isMatching(String word, String[] words) {
        for (String w : words) {
            if (w.equals(word))
                continue;
            if (w.contains(word))
                return true;
        }
        return false;
    }
}