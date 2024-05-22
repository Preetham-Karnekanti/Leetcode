class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    public int helper(int nums[], int start, int end) {
        int prev = nums[start];
        int prev1 = 0;
        for (int i = start + 1; i <= end; i++) {
            int cur = Math.max(prev, prev1 + nums[i]);
            prev1 = prev;
            prev = cur;
        }
        return prev;
    }
}