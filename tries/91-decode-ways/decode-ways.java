class Solution {
    int dp[];

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0);
    }

    public int helper(String s, int idx) {
        if (idx >= s.length())
            return 1;
        if (dp[idx] != -1)
            return dp[idx];
        if (s.charAt(idx) == '0')
            return 0;
        int count = helper(s, idx + 1);
        if (idx + 1 < s.length()) {
            String num = "" + s.charAt(idx) + s.charAt(idx + 1);
            int num1 = Integer.parseInt(num);
            if (num1 <= 26) {
                count += helper(s, idx + 2);
            }
        }
        return dp[idx] = count;
    }
}