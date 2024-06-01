class Solution {
    static int m = (int) 1e9 + 7;
    Integer dp[];

    public int numberOfArrays(String s, int k) {
        dp = new Integer[s.length()];
        return helper(s, 0, k);
    }

    public int helper(String s, int idx, int k) {
        if (idx == s.length())
            return 1;
        if (dp[idx] != null)
            return dp[idx];
        if (s.charAt(idx) == '0')
            return 0;
        int count = 0;
        for (int i = idx; i < s.length(); i++) {
            Long number = Long.parseLong(s.substring(idx, i + 1));
            if (number > k)
                break;
            count = (count + helper(s, i + 1, k)) % m;
        }
        return dp[idx] = count;
    }
}