class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum = sum / 2;
        int n = nums.length;
        boolean prev[] = new boolean[sum + 1];
        if (nums[0] <= sum) {
            prev[nums[0]] = true;
        }
        prev[0] = true;
        for (int i = 1; i < n; i++) {
            boolean cur[] = new boolean[sum + 1];
            for (int j = 1; j <= sum; j++) {
                cur[j] = prev[j];
                if (j - nums[i] >= 0)
                    cur[j] = prev[j - nums[i]] || cur[j];
            }
            prev = cur;
        }
        return prev[sum];
    }
}