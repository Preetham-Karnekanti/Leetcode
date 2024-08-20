class Solution {
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        HashSet<String> words = new HashSet<>(wordDict);
        return solve(s, 0, words);
    }

    public boolean solve(String s, int idx, HashSet<String> dictionary) {
        if (idx >= s.length()) {
            return true;
        }
        if (dp[idx] != -1)
            return dp[idx] == 1 ? true : false;
        for (int i = idx; i < s.length(); i++) {
            if (!dictionary.contains(s.substring(idx, i + 1)))
                continue;
            if (solve(s, i + 1, dictionary)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}