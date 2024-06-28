class Solution {
    public int minimumPartition(String s, int k) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        int ans = helper(s, 0, k, dp);
        return ans >= (int) 1e9 ? -1 : ans;
    }

    public int helper(String s, int idx, int k, int dp[]) {
        if (idx == s.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int min = (int) 1e9;
        String kStr = String.valueOf(k);
        for (int i = idx; i < s.length(); i++) {
            String subStr = s.substring(idx, i + 1);
            if (subStr.length() > kStr.length())
                break;
            if (Integer.parseInt(subStr) > k)
                break;
            int cost = 1 + helper(s, i + 1, k, dp);
            min = Math.min(min, cost);
        }
        return dp[idx] = min;
    }
}