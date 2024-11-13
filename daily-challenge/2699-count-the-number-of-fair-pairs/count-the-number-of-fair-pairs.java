class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            long x = bs1(nums, i + 1, lower - nums[i]);
            long y = bs2(nums, i + 1, upper - nums[i]);
            count += (y - x);
        }
        return count;
    }

    public int bs1(int nums[], int idx, int target) {
        int low = idx;
        int high = nums.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return low;
    }

    public int bs2(int nums[], int idx, int target) {
        int low = idx;
        int high = nums.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return low;
    }
}