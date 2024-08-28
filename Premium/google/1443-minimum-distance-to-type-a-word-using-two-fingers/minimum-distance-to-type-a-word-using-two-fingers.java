class Solution {
    public int minimumDistance(String word) {
        Integer dp[][][] = new Integer[word.length()][27][27];
        return helper(word, 0, -1, -1, dp);
    }

    public int helper(String word, int idx, int prev1, int prev2, Integer[][][] dp) {
        if (idx == word.length())
            return 0;
        if (dp[idx][prev1 + 1][prev2 + 1] != null)
            return dp[idx][prev1 + 1][prev2 + 1];
        int one = getCost(word.charAt(idx) - 'A', prev1) + helper(word, idx + 1, word.charAt(idx) - 'A', prev2, dp);
        int two = getCost(word.charAt(idx) - 'A', prev2) + helper(word, idx + 1, prev1, word.charAt(idx) - 'A', dp);
        return dp[idx][prev1 + 1][prev2 + 1] = Math.min(one, two);
    }

    public int getCost(int idx1, int idx2) {
        if (idx2 == -1)
            return 0;
        int co1[] = getCooridinates(idx1);
        int co2[] = getCooridinates(idx2);
        return Math.abs(co1[0] - co2[0]) + Math.abs(co1[1] - co2[1]);
    }

    public int[] getCooridinates(int value) {
        return new int[] { value / 6, value % 6 };
    }
}