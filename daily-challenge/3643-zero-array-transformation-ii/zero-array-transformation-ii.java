class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (!isPossible(nums, queries, queries.length))
            return -1;
        int low = 0;
        int high = queries.length;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, queries, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int nums[], int queries[][], int k) {
        int n = nums.length, sum = 0;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            prefix[l] += val;
            prefix[r + 1] -= val;
        }

        for (int i = 0; i < n; i++) {
            sum += prefix[i];
            if (sum < nums[i])
                return false;
        }
        return true;
    }
}