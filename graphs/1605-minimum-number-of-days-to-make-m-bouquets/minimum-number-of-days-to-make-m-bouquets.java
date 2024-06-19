class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = 0;
        int ans = -1;
        for (int i : bloomDay) {
            high = Math.max(high, i);
            low = Math.min(low, i);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossibleWithinMidDays(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossibleWithinMidDays(int[] nums, int days, int m, int k) {
        int bouquetsMadeTillNow = 0;
        int adjacentCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= days) {
                adjacentCount++;
            } else {
                adjacentCount = 0;
            }
            if (adjacentCount == k) {
                bouquetsMadeTillNow++;
                adjacentCount = 0;
            }
            if (bouquetsMadeTillNow >= m)
                return true;
        }
        return bouquetsMadeTillNow >= m;
    }
}