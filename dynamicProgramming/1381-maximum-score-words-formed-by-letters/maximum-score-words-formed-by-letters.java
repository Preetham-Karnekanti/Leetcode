class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for (int i = 0; i < letters.length; i++) {
            freq[letters[i] - 'a']++;
        }
        return helper(words, score, freq, 0);
    }

    public static int helper(String[] words, int[] score, int freq[], int idx) {
        if (idx == words.length)
            return 0;
        int notTake = helper(words, score, freq, idx + 1);
        boolean isValid = true;
        int curScore = 0;
        for (int i = 0; i < words[idx].length(); i++) {
            int index = words[idx].charAt(i) - 'a';
            if (freq[index] <= 0) {
                isValid = false;
            }
            freq[index]--;
            curScore += score[index];
        }
        int take = 0;
        if (isValid) {
            take = curScore + helper(words, score, freq, idx + 1);
        }
        for (int i = 0; i < words[idx].length(); i++) {
            int index = words[idx].charAt(i) - 'a';
            freq[index]++;
        }
        return Math.max(take, notTake);
    }
}