class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, new boolean[n], ans, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, boolean vis[], List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            temp.add(nums[i]);
            solve(nums, vis, ans, temp);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}