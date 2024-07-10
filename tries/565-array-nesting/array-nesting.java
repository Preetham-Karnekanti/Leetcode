class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i])
                ans = Math.max(ans, dfs(i, nums, vis));
        }
        return ans;
    }

    public int dfs(int idx, int[] nums, boolean[] vis) {
        if (vis[idx] || idx >= nums.length)
            return 0;
        vis[idx] = true;
        return 1 + dfs(nums[idx], nums, vis);
    }
}