class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (char ch : word.toCharArray()) {
                weight += weights[ch - 'a'];
            }
            weight %= 26;
            answer.append((char) (25 - weight + 'a'));
        }
        return answer.toString();
    }
}