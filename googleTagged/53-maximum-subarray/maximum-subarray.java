class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int nums[], int low, int high) {
        if (low == high)
            return nums[low];
        int mid = (low + high) / 2;
        int maxLeftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            maxLeftSum = Math.max(maxLeftSum, sum);
        }

        int maxRightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            maxRightSum = Math.max(maxRightSum, sum);
        }
        int max = Math.max(helper(nums, low, mid), helper(nums, mid + 1, high));
        return Math.max(max, maxRightSum + maxLeftSum);
    }
}