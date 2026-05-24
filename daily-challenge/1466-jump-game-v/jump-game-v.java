class Solution {
    int dp[];
    public int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, helper(arr, i, d));
        }
        return ans;
    }

    public int helper(int arr[], int i, int d) {
        if(dp[i] != -1)
            return dp[i];
        int ans = 1;
        for (int j = i + 1; j <= i + d && j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                ans = Math.max(ans, 1 + helper(arr, j, d));
            } else {
                break;
            }
        }
        for (int j = i - 1; j >= i - d && j >= 0; j--) {
            if (arr[i] > arr[j]) {
                ans = Math.max(ans, 1 + helper(arr, j, d));
            } else{
                break;
            }
        }
        return dp[i] = ans;
    }
}