class Solution {
    int dp[][];

    public int maxHeight(int[][] cuboids) {
        dp = new int[cuboids.length][cuboids.length + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < cuboids.length; i++)
            Arrays.sort(cuboids[i]);
        Arrays.sort(cuboids, (a, b) -> {
            return b[0] * b[1] * b[2] - a[0] * a[1] * a[2];
        });
        return helper(cuboids, 0, -1);
    }

    public int helper(int[][] cuboids, int idx, int prev) {
        if (idx == cuboids.length)
            return 0;
        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];
        int notTake = helper(cuboids, idx + 1, prev);
        int take = 0;
        if (prev == -1 || check(cuboids[prev], cuboids[idx])) {
            take = cuboids[idx][2] + helper(cuboids, idx + 1, idx);
        }
        return dp[idx][prev + 1] = Math.max(take, notTake);
    }

    public boolean check(int[] a, int b[]) {
        return a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2];
    }
}