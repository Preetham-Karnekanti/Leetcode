class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        int idx = 0;
        int max = 1;
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (isAtOneDistance(words[i], words[j])
                        && groups[i] != groups[j]
                        && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        ans.add(words[idx]);
        while (idx != hash[idx]) {
            idx = hash[idx];
            ans.add(words[idx]);
        }
        Collections.reverse(ans);
        return ans;
    }

    public boolean isAtOneDistance(String word1, String word2) {
        int count = 0;
        if (word1.length() != word2.length())
            return false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return count == 1;
    }
}