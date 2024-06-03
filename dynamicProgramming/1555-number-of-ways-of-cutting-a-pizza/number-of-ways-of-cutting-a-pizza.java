class Solution {

    public int dfs(int r, int c, int k, String[] pizza, Integer[][][] dp, int[][] preSum) {
        // if there are no apples in current sub-pizza return 0
        if (preSum[r][c] == 0)
            return 0;

        // if no cuts remains and current sub-pizza has atleast an apple
        if (k == 0)
            return 1;

        // already memoized return the valuee
        if (dp[r][c][k] != null) {
            return dp[r][c][k];
        }

        int ans = 0;

        int m = pizza.length, n = pizza[0].length();

        // horizontal cuts

        for (int nr = r + 1; nr < m; nr++) {
            // cut if the upper piece contains an apple
            if (preSum[r][c] - preSum[nr][c] > 0) {
                ans = (ans + dfs(nr, c, k - 1, pizza, dp, preSum)) % 1_000_000_007;
            }
        }

        // vertical cuts
        for (int nc = c + 1; nc < n; nc++) {
            // cut if the left piece contains an apple

            if (preSum[r][c] - preSum[r][nc] > 0) {
                ans = (ans + dfs(r, nc, k - 1, pizza, dp, preSum)) % 1_000_000_007;
            }

        }

        return dp[r][c][k] = ans;

    }

    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        Integer[][][] dp = new Integer[m][n][k];
        // 3D array to store values
        // presum stores total number of apples in current sub-pizza
        int[][] preSum = new int[m + 1][n + 1];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                preSum[r][c] = preSum[r + 1][c] + preSum[r][c + 1] - preSum[r + 1][c + 1]
                        + (pizza[r].charAt(c) == 'A' ? 1 : 0);

            }
        }

        return dfs(0, 0, k - 1, pizza, dp, preSum);
    }

}