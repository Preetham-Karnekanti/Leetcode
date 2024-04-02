class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        return subset(nums, 0, 0);
    }

    public int subset(int nums[], int idx, int result) {
        if (idx == nums.length)
            return result;
        return subset(nums, idx + 1, result ^ nums[idx]) + subset(nums, idx + 1, result);
    }
}