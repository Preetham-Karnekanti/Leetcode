class Solution {
    private long ans = Long.MIN_VALUE;

    public void helper(int[] nums, int ind, long prod, boolean took) {
        if (ind == nums.length) {
            if (took) {
                ans = Math.max(ans, prod);
            }
            return;
        }
        helper(nums, ind + 1, prod * nums[ind], true);
        helper(nums, ind + 1, prod, took);
    }

    public long maxStrength(int[] nums) {
        helper(nums, 0, 1, false);
        return ans;
    }
}