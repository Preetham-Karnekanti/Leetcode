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
                if (waterStartTime[j] < end) {
                    min = Math.min(min, end + waterDuration[j]);
                } else {
                    int wait = Math.abs(end - waterStartTime[j]);
                    min = Math.min(min, wait + end + waterDuration[j]);
                }
            }
        }
        return min;
    }
}