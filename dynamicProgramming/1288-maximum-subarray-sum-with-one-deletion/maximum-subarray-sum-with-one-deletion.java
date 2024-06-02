class Solution {
    int dp[][];

    int help(int arr[], int curr, int k) {
        if (curr == arr.length)
            return 0;

        if (k < 0)
            return 0;

        if (dp[curr][k] != -1)
            return dp[curr][k];

        return dp[curr][k] = Math.max(arr[curr] + help(arr, curr + 1, k), help(arr, curr + 1, k - 1));
    }

    public int maximumSum(int[] arr) {

        dp = new int[arr.length][2];

        for (int i[] : dp)
            Arrays.fill(i, -1);

        int flag = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                flag++;
            max = Math.max(max, arr[i]);
        }
        if (flag == 0)
            return max;

        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, help(arr, i, 1));
        }
        return res;
    }
}