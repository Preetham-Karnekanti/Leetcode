class Solution {
    Integer dp[][];

    public int tallestBillboard(int[] rods) {
        dp = new Integer[rods.length][100002];
        return helper(rods, 0, 0);
    }

    public int helper(int[] rods, int idx, int diff) {
        if (rods.length == idx) {
            if (diff == 0)
                return 0;
            else
                return -9999999;
        }
        if (dp[idx][diff + 50001] != null)
            return dp[idx][diff + 50001];
        int skip = helper(rods, idx + 1, diff);
        int add = helper(rods, idx + 1, diff + rods[idx]) + rods[idx];
        int sub = helper(rods, idx + 1, diff - rods[idx]);
        return dp[idx][diff + 50001] = Math.max(skip, Math.max(add, sub));
    }
}