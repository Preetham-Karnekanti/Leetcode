class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && i + 2 < n) {
                nums[i] = 1;
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count++;
            }
        }
        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {
            return -1;
        }
        return count;
    }
}