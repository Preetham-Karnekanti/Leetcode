class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long dp[] = new long[rides.length];
        Arrays.fill(dp, -1);
        Arrays.sort(rides, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        return helper(rides, 0, dp);
    }

    public long helper(int[][] rides, int idx, long[] dp) {
        if (idx == rides.length) {
            return 0;
        }
        if (dp[idx] != -1)
            return dp[idx];
        long max = helper(rides, idx + 1, dp);
        long cur = rides[idx][2] + rides[idx][1] - rides[idx][0];
        // for (int i = idx + 1; i < rides.length; i++) {
        //     if (rides[idx][1] <= rides[i][0])
        //         max = Math.max(max, cur + helper(rides, i, dp));
        // }
        int low = idx + 1;
        int high = rides.length - 1;
        int tempIdx = rides.length;
        while (low <= high) {
            int mid = (low + high)/2;
            if(rides[idx][1] <= rides[mid][0]){
                tempIdx = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        max = Math.max(max, cur + helper(rides, tempIdx, dp));
        return dp[idx] = Math.max(max, cur);
    }
}