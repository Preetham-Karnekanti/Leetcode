class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new boolean[n], ans, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, boolean vis[], List<List<Integer>> ans, List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i])
                continue;
            temp.add(nums[i]);
            vis[i] = true;
            helper(nums, vis, ans, temp);
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }
}