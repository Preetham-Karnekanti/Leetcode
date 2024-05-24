class Solution {
    int dp[];

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0);
    }

    public int helper(String s, int idx) {
        if (idx >= s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0')
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int count = helper(s, idx + 1);
        if (idx + 1 < s.length() && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
            String num = "" + s.charAt(idx) + s.charAt(idx + 1);
            int num1 = Integer.parseInt(num);
            if (num1 <= 26)
                count += helper(s, idx + 2);
        }
        return dp[idx] = count;
    }
}