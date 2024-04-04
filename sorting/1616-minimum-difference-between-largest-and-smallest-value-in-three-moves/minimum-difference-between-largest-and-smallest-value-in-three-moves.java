class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n <= 4)
            return 0;
        int ans1 = nums[n - 1] - nums[3];
        int ans2 = nums[n - 4] - nums[0];
        int ans3 = nums[n - 2] - nums[2];
        int ans4 = nums[n - 3] - nums[1];
        return Math.min(Math.min(ans1, ans2), Math.min(ans3, ans4));
    }
}