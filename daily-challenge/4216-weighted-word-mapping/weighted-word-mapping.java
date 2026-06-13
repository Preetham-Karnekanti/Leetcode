class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        char[] tempChar = new char[words.length];
        int i = 0;
        for (String word : words) {
            int weight = 0;
            for (char ch : word.toCharArray()) {
                weight += weights[ch - 'a'];
            }
            weight %= 26;
            tempChar[i] = (char) (25 - weight + 'a');
            i++;
        }
        return new String(tempChar);
    }
}