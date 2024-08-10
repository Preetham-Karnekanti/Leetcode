class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int max = 0;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, intervals[i][1]);
        }
        int timeline[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            timeline[intervals[i][0]]++;
            timeline[intervals[i][1]]--;
        }
        for (int i = 1; i <= max; i++)
            timeline[i] += timeline[i - 1];

        for (int i = 0; i <= max; i++)
            if (timeline[i] > 1)
                return false;
        return true;
    }
}