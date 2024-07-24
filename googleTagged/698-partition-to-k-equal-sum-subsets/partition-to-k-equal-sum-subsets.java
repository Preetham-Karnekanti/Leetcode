class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i : nums)
            sum += i;
        if (sum % k != 0)
            return false;
        sum = sum / k;
        HashSet<Integer> hs = new HashSet<>();
        return solve(nums, k, sum, hs, 0, 0);
    }

    public boolean solve(int nums[], int k, int targetSum, HashSet<Integer> hs, int idx, int sum) {
        if (k == 0)
            return true;
        if (targetSum == sum) {
            return solve(nums, k - 1, targetSum, hs, 0, 0);
        }
        if (sum > targetSum)
            return false;
        if (idx == nums.length)
            return false;
        for (int i = idx; i < nums.length; i++) {
            if (hs.contains(i) || sum + nums[i] > targetSum)
                continue;
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && !hs.contains(i - 1))
                continue;
            hs.add(i);
            if (solve(nums, k, targetSum, hs, i + 1, sum + nums[i]))
                return true;
            hs.remove(i);
        }
        return false;
    }
}