class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        int a = solve(nums, 0, nums.length - 1);
        int b = sum - a;
        return a >= b;
    }

    public int solve(int[] nums, int i, int j) {
        if (i > j)
            return 0;
        if (i == j)
            return nums[j];
        int left = nums[i] + Math.min(solve(nums, i + 2, j), solve(nums, i + 1, j - 1));
        int right = nums[j] + Math.min(solve(nums, i, j - 2), solve(nums, i + 1, j - 1));
        return Math.max(left, right);
    }
}