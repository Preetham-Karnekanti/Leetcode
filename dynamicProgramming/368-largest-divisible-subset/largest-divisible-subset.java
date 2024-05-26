class Solution {
    ArrayList<Integer> res;
    int dp[];

    public List<Integer> largestDivisibleSubset(int[] nums) {
        dp = new int[nums.length];
        res = new ArrayList<>();
        Arrays.sort(nums);
        Arrays.fill(dp, -1);
        helper(nums, 0, -1, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int idx, int prev, ArrayList<Integer> temp) {
        if (idx == nums.length) {
            if (temp.size() > res.size()) {
                res = new ArrayList<>(temp);
            }
            return;
        }
        int cur = nums[idx];
        if (dp[idx] < temp.size() && cur % prev == 0) {
            dp[idx] = temp.size();
            temp.add(cur);
            helper(nums, idx + 1, cur, temp);
            temp.remove(temp.size() - 1);
        }
        helper(nums, idx + 1, prev, temp);
    }
}