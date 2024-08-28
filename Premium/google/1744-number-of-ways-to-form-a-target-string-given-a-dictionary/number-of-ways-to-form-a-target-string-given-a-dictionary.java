class Solution {
    int mod = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int maxLength = words[0].length();
        int dp[][] = new int[maxLength + 1][target.length() + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(words, 0, target, 0, maxLength, dp);
    }

    public int helper(String words[], int chIdx, String target, int tIdx, int maxLen, int[][] dp) {
        if (tIdx == target.length())
            return 1;
        if (chIdx == maxLen || maxLen - chIdx < target.length() - tIdx) // remianing unused characters < needed characters 
            return 0;
        if (dp[chIdx][tIdx] != -1)
            return dp[chIdx][tIdx];
        int ways = 0;
        ways = helper(words, chIdx + 1, target, tIdx, maxLen, dp) % mod;
        for (String word : words) {
            if (word.charAt(chIdx) == target.charAt(tIdx))
                ways = (ways + helper(words, chIdx + 1, target, tIdx + 1, maxLen, dp)) % mod;
        }
        return dp[chIdx][tIdx] = ways;
    }
}