class Solution {
    int dp[];

    public int minimumSubstringsInPartition(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }

    public int solve(String s, int idx) {
        if (idx == s.length()) {
            return 0;
        }
        if (dp[idx] != -1)
            return dp[idx];
        int freq[] = new int[26];
        int ans = Integer.MAX_VALUE;
        for (int i = idx; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int k = 0; k < 26; k++) {
                if (freq[k] > 0) {
                    min = Math.min(min, freq[k]);
                    max = Math.max(max, freq[k]);
                }
            }
            if (min == max) {
                ans = Math.min(ans, 1 + solve(s, i + 1));
            }
        }
        return dp[idx] = ans;
    }
}