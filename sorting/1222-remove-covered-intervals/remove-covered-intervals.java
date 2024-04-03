class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int len = intervals.length;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int cur[] = intervals[i];
            if (cur[1] <= prev[1]) {
                len--;
            } else {
                prev = cur;
            }
        }
        return len;
    }
}