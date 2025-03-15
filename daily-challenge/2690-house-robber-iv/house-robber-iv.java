class Solution {
    public int minCapability(int[] nums, int k) {
        int low = nums[0];
        int high = nums[0];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, nums, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int max, int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= max) {
                count++;
                i++;
            }
            if (count >= k)
                return true;
        }
        return false;
    }
}