class Solution {
    Integer dp[][];

    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        dp = new Integer[n][n + 1];
        Arrays.sort(satisfaction);
        return helper(satisfaction, 0, 1);
    }

    public int helper(int[] arr, int idx, int taken) {
        if (idx == arr.length)
            return 0;
        if (dp[idx][taken] != null)
            return dp[idx][taken];
        int notTake = helper(arr, idx + 1, taken);
        int take = arr[idx] * taken + helper(arr, idx + 1, taken + 1);
        return dp[idx][taken] = Math.max(take, notTake);
    }
}