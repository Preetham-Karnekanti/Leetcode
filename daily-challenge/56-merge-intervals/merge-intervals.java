class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        ArrayList<int[]> answer = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && end >= intervals[j][0]) {
                end = Math.max(end, intervals[j++][1]);
            }
            i = j;
            answer.add(new int[] { start, end });
        }
        return answer.toArray(new int[0][0]);
    }
}