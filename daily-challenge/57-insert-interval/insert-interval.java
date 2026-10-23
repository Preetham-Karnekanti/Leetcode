class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        List<List<Integer>> answer = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            answer.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }
        int newStart = newInterval[0];
        if (i < n)
            newStart = Math.min(newInterval[0], intervals[i][0]);
        int newEnd = newInterval[1];
        while (i < n && newEnd >= intervals[i][0]) {
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        answer.add(new ArrayList<>(List.of(newStart, newEnd)));
        while (i < n) {
            answer.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }
        int ans[][] = new int[answer.size()][2];
        for (i = 0; i < answer.size(); i++) {
            ans[i] = new int[] { answer.get(i).get(0), answer.get(i).get(1) };
        }
        return ans;
    }
}