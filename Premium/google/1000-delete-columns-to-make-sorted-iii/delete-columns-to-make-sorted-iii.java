class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        Integer dp[][] = new Integer[n + 1][n + 1];
        return n - helper(strs, 0, -1, dp);
    }

    public int helper(String words[], int idx, int prev, Integer[][] dp) {
        if (idx == words[0].length())
            return 0;
        if(dp[idx][prev + 1] != null)
            return dp[idx][prev + 1];
        int skip = helper(words, idx + 1, prev, dp);
        boolean canKeepCurrent = true;
        if (prev != -1) {
            for (String row : words) {
                if (row.charAt(prev) > row.charAt(idx)) {
                    canKeepCurrent = false;
                    break;
                }
            }
        }

        int keepCurrent = 0;
        if (canKeepCurrent) {
            keepCurrent = 1 + helper(words, idx + 1, idx, dp);
        }

        int result = Math.max(skip, keepCurrent);
        return dp[idx][prev + 1] = result;
    }
}