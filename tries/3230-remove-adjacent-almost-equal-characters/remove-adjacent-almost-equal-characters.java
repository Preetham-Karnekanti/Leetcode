class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int dp[] = new int[word.length()];
        Arrays.fill(dp, -1);
        return helper(word, 0, dp);
    }

    public int helper(String word, int idx, int[] dp) {
        if (idx >= word.length())
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        if (idx + 1 < word.length()
                && (word.charAt(idx) == word.charAt(idx + 1) || isAdjacent(word.charAt(idx), word.charAt(idx + 1))))
            return dp[idx] = 1 + helper(word, idx + 2, dp);
        return dp[idx] = helper(word, idx + 1, dp);
    }

    public boolean isAdjacent(char a, char b) {
        return Math.abs((int) a - (int) b) == 1;
    }
}