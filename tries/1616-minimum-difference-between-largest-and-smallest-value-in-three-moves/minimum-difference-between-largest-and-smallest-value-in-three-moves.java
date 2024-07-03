class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 3)
            return 0;
        Arrays.sort(nums);
        int min1 = nums[n - 3] - nums[1];
        int min2 = nums[n - 2] - nums[2];
        int min3 = nums[n - 4] - nums[0];
        int min4 = nums[n - 1] - nums[3];
        return Math.min(Math.min(min2, min1), Math.min(min3, min4));
    }
}