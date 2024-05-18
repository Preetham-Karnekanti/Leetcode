class Solution {
    public int minOperations(int[] nums) {
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                moves += Math.abs(nums[i] - nums[i - 1]) + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }
}