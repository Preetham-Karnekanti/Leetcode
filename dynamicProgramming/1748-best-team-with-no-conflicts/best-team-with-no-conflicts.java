class Solution {
    Integer dp[][];

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        dp = new Integer[n][n + 1];
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return helper(arr, 0, -1);
    }

    public int helper(int arr[][], int idx, int prev) {
        if (idx == arr.length)
            return 0;
        if (dp[idx][prev + 1] != null)
            return dp[idx][prev + 1];
        int notTake = helper(arr, idx + 1, prev);
        int take = 0;
        if (prev == -1 || arr[idx][1] >= arr[prev][1]) {
            take = arr[idx][1] + helper(arr, idx + 1, idx);
        }
        return dp[idx][prev + 1] = Math.max(take, notTake);
    }
}