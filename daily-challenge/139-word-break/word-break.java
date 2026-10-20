class Solution {
    Boolean dp[];

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        HashSet<String> hs = new HashSet<>(wordDict);
        return helper(s, hs, 0);
    }

    public boolean helper(String s, HashSet<String> hs, int idx) {
        if (idx == s.length())
            return true;
        if (dp[idx] != null)
            return dp[idx];
        for (int i = idx; i < s.length(); i++) {
            if (hs.contains(s.substring(idx, i + 1))) {
                if (helper(s, hs, i + 1))
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}