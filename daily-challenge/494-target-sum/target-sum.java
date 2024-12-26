class Solution {
    HashMap<String, Integer> hm;

    public int findTargetSumWays(int[] nums, int target) {
        hm = new HashMap<>();
        return helper(nums, 0, target);
    }

    public int helper(int nums[], int idx, int target) {
        String key = idx + ":" + target;
        if (target == 0 && idx == nums.length)
            return 1;
        if (idx == nums.length)
            return 0;
        if (hm.containsKey(key))
            return hm.get(key);
        int ways = helper(nums, idx + 1, target - nums[idx]) + helper(nums, idx + 1, target + nums[idx]);
        hm.put(key, ways);
        return ways;
    }
}