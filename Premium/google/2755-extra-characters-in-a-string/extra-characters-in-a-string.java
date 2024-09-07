class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        HashSet<String> hs = new HashSet<>(Arrays.asList(dictionary));
        return helper(s, hs, 0, dp);
    }
    public int helper(String s, HashSet<String> hs, int idx, int[] dp){
        if(idx == s.length())
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        int skip = helper(s, hs, idx + 1, dp) + 1;
        for(int i = idx;i < s.length();i++){
            if(hs.contains(s.substring(idx, i + 1))){
                skip = Math.min(skip, helper(s, hs, i + 1, dp));
            }
        }
        return dp[idx] = skip;
    }
}