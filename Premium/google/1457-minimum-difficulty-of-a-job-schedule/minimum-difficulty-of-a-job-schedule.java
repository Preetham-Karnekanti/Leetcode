class Solution {
    public int minDifficulty(int[] arr, int d) {
        if (d > arr.length)
            return -1;
        int dp[][] = new int[arr.length][d + 1];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        return helper(arr, d, 0, dp);
    }

    public int helper(int arr[], int d, int idx, int[][] dp) {
        if (idx == arr.length) {
            return d != 0 ? (int) 1e9 : 0;
        }
        if (d < 0)
            return (int) 1e9;

        if (dp[idx][d] != -1)
            return dp[idx][d];
        int max = -1;
        int min = (int) 1e9;
        for (int i = idx; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, max + helper(arr, d - 1, i + 1, dp));
        }
        return dp[idx][d] = min;
    }
}