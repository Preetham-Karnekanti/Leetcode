class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0);
    }

    public int helper(String s, int idx){
        if(idx >= s.length())
            return 1;
        if(s.charAt(idx) == '0')
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        int ways = helper(s, idx + 1);
        if(idx + 1 < s.length()){
            int ch1 = s.charAt(idx) - '0';
            int ch2 = s.charAt(idx + 1) - '0';
            int num = ch1 * 10 + ch2;
            if(num >= 1 && num <= 26)
                ways += helper(s, idx + 2);
        }
        return dp[idx] = ways;
    }
}