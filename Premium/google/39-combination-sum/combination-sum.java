class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, int idx, int target, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (idx == nums.length)
            return;
        if (nums[idx] <= target) {
            temp.add(nums[idx]);
            solve(nums, idx, target - nums[idx], ans, temp);
            temp.remove(temp.size() - 1);
        }
        solve(nums, idx + 1, target, ans, temp);
    }
}