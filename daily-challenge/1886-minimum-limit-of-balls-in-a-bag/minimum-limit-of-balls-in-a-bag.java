class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = nums[0];
        int ans = -1;
        for (int i : nums)
            high = Math.max(high, i);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, maxOperations)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public boolean isPossible(int nums[], int min, int maxOperations) {
        int ops = 0;
        for (int i : nums) {
            if (i % min == 0)
                ops += (i / min) - 1;
            else
                ops += i / min;
            if (ops > maxOperations)
                return false;
        }
        return true;
    }
}