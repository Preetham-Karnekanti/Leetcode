class Solution {

    private int solveMemo(int[] pref, int m, int p, int[][] dp) {
        // Edge Case
        if (p + 2 * m >= pref.length) {
            return pref[p];
        }
        if (dp[p][m] > 0)
            return dp[p][m];
        int res = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int take = pref[p] - pref[p + 1];
            res = Math.max(res, take + pref[p + 1] - solveMemo(pref, Math.max(i, m), p + i, dp));
        }
        return dp[p][m] = res;
    }

    public int stoneGameII(int[] piles) {
        int[] pref = Arrays.copyOf(piles, piles.length);
        for (int i = pref.length - 2; i >= 0; i--) {
            pref[i] += pref[i + 1];
        }

        return solveMemo(pref, 1, 0, new int[piles.length][piles.length]);
    }
}