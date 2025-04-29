class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> answer = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            answer.add(intervals[i++]);
        }
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < n && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        answer.add(new int[] { start, end });
        while (i < n) {
            answer.add(intervals[i++]);
        }
        return answer.toArray(new int[0][0]);
    }
}