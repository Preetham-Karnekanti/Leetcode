class Solution {
    int dp[];

    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        dp = new int[energy.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < energy.length; i++) {
            max = Math.max(max, solve(energy, i, k));
        }
        return max;
    }

    public int solve(int[] energy, int idx, int k) {
        if (idx >= energy.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int cur = energy[idx] + solve(energy, idx + k, k);
        dp[idx] = cur;
        return cur;
    }
}