class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target,0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int[] nums, int target, int idx, List<Integer> temp, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx == nums.length || target < 0)
            return;
        temp.add(nums[idx]);
        helper(nums, target - nums[idx],idx + 1, temp, ans);
        temp.remove(temp.size()-1);
        idx++;
        while(idx > 0 && idx < nums.length&& nums[idx] == nums[idx - 1])
            idx++;
        helper(nums, target, idx,temp, ans);
    }
}