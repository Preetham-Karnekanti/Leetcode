class Solution {
    int dp[];

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        return helper(arr, 0, k);
    }

    public int helper(int[] arr, int idx, int k) {
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx] != 0)
            return dp[idx];
        int max = 0, res = 0;
        for (int i = idx; i < idx + k && i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            res = Math.max(res, helper(arr, i + 1, k) + (i - idx + 1) * max);
        }
        return dp[idx] = res;
    }
}