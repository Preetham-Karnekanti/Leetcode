class Solution {
    int dp[];

    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0) - 1;
    }

    public int helper(String s, int idx) {
        if (idx >= s.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int min = (int) 1e6;
        for (int i = idx; i < s.length(); i++) {
            int ans = (int) 1e6;
            if (isPallindrome(s, idx, i)) {
                ans = 1 + helper(s, i + 1);
            }
            min = Math.min(min, ans);
        }
        return dp[idx] = min;
    }

    public boolean isPallindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}