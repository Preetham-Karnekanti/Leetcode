class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(helper(landStartTime, landDuration, waterStartTime, waterDuration),
                helper(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    public int helper(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;
        for (int i = 0; i < n; i++) {
            int end = landDuration[i] + landStartTime[i];
            for (int j = 0; j < m; j++) {
                int wait;
                if (waterStartTime[j] < end) {
                    wait = 0;
                } else {
                    wait = Math.abs(end - waterStartTime[j]);
                }
                min = Math.min(min, end + waterDuration[j] + wait);
            }
        }
        return min;
    }
}