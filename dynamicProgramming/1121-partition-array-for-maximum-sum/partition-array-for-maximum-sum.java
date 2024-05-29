class Solution {
    int dp[];

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, k, 0);
    }

    public int helper(int[] arr, int k, int i) {
        if (i == arr.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int max = 0, res = 0;
        for (int j = i; j < arr.length && j < i + k; j++) {
            max = Math.max(max, arr[j]);
            res = Math.max(res, (j - i + 1) * max + helper(arr, k, j + 1));
        }
        return dp[i] = res;
    }
}