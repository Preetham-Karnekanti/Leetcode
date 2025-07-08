class Solution {
    public int solve(int[][] events, int k, int idx, int size, int[][] dp) {
        if (idx >= events.length || size >= k)
            return 0;
        else if (dp[idx][size] != 0)
            return dp[idx][size];
        int max = Integer.MIN_VALUE;
        int low = idx + 1, high = events.length - 1;
        int nextEventIdx = events.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > events[idx][1]) {
                high = mid - 1;
                nextEventIdx = mid;
            } else {
                low = mid + 1;
            }
        }
        max = Math.max(max, events[idx][2] + solve(events, k, nextEventIdx, size + 1, dp));
        max = Math.max(max, solve(events, k, idx + 1, size, dp));
        dp[idx][size] = max;
        return max;
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        int[][] dp = new int[events.length][k + 1];
        return solve(events, k, 0, 0, dp);
    }
}