class Solution {
    int ans = 0;

    private int dfs(int n, int[] cost, int i) {
        if (i >= n)
            return 0;

        int l = cost[i] + dfs(n, cost, 2 * i + 1);
        int r = cost[i] + dfs(n, cost, 2 * i + 2);
        ans += Math.abs(l - r);

        return Math.max(l, r);
    }

    public int minIncrements(int n, int[] cost) {
        dfs(n, cost, 0);
        return ans;
    }
}