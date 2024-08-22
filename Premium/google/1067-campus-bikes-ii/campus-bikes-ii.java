class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int m = bikes.length;
        int dp[] = new int[(1 << m)];
        Arrays.fill(dp, -1);
        return helper(workers, bikes, 0, 0, dp);
    }

    public int helper(int workers[][], int[][] bikes, int wIdx, int mask, int[] dp) {
        if (wIdx >= workers.length)
            return 0;
        if (dp[mask] != -1)
            return dp[mask];
        int distance = Integer.MAX_VALUE;
        for (int bIdx = 0; bIdx < bikes.length; bIdx++) {
            if (checkBit(mask, bIdx) == 0) {
                distance = Math.min(distance, findDistance(workers[wIdx], bikes[bIdx])
                        + helper(workers, bikes, wIdx + 1, mask | (1 << bIdx), dp));
            }
        }
        return dp[mask] = distance;
    }

    public int findDistance(int p1[], int p2[]) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p2[1] - p1[1]);
    }

    public int checkBit(int num, int i) {
        num = num >> i;
        return (num & 1);
    }
}