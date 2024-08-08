class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }

    public void helper(int[] candidates, int target, ArrayList<Integer> temp, List<List<Integer>> ans, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0)
            return;
        if (idx == candidates.length)
            return;
        temp.add(candidates[idx]);
        helper(candidates, target - candidates[idx], temp, ans, idx);
        temp.remove(temp.size() - 1);
        helper(candidates, target, temp, ans, idx + 1);
    }
}