class Solution {
    public boolean canPartitionKSubsets(int[] nums, int K) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        if (sum % K != 0)
            return false;
        return helper(nums, 0, 0, sum / K, K);
    }

    public static boolean helper(int[] nums, int idx, int sum, int target, int k) {
        if (k == 0)
            return true;
        if (sum == target)
            return helper(nums, 0, 0, target, k - 1);
        if (idx >= nums.length)
            return false;
        if (nums[idx] != -1 && sum + nums[idx] <= target) {
            int val = nums[idx];
            nums[idx] = -1;
            if (helper(nums, idx + 1, sum + val, target, k))
                return true;
            nums[idx] = val;
        }
        return helper(nums, idx + 1, sum, target, k);
    }
}