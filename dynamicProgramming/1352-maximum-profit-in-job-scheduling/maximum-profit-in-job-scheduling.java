class Solution {
    Integer dp[];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        dp = new Integer[n];
        int task[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            task[i][0] = startTime[i];
            task[i][1] = endTime[i];
            task[i][2] = profit[i];
        }
        Arrays.sort(task, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        return helper(task, 0);
    }

    public int helper(int task[][], int idx) {
        if (idx >= task.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        int j = idx + 1;
        while (j < task.length && task[j][0] < task[idx][1])
            j++;
        return dp[idx] = Math.max(helper(task, j) + task[idx][2], helper(task, idx + 1));
    }
}