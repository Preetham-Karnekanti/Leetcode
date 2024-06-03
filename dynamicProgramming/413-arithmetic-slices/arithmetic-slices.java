class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;
        return rec(nums, n, 0);
    }

    public int rec(int[] nums, int n, int counter) {
        if (n < 3)
            return 0;
        if (nums[n - 1] - nums[n - 2] == nums[n - 2] - nums[n - 3]) {
            counter++;
            return counter + rec(nums, n - 1, counter);
        } else
            return rec(nums, n - 1, 0);
    }
}