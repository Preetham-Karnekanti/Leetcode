class Solution {
    int dp[][];

    public boolean predictTheWinner(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int P1points = helper(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i : nums)
            sum += i;
        int p2 = sum - P1points;
        if (P1points >= p2)
            return true;
        return false;
    }

    public int helper(int nums[], int start, int end) {
        if (start > end)
            return 0;
        if (dp[start][end] != -1)
            return dp[start][end];
        int one = nums[start] + Math.min(helper(nums, start + 2, end), helper(nums, start + 1, end - 1));
        int two = nums[end] + Math.min(helper(nums, start + 1, end - 1), helper(nums, start, end - 2));
        return dp[start][end] = Math.max(one, two);
    }
}