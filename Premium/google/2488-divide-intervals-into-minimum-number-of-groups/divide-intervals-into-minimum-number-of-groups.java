class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int p1 = 0, p2 = 0;
        int cnt = 0, max = 0;
        while (p1 < n && p2 < n) {
            if (start[p1] <= end[p2]) {
                cnt++;
                p1++;
            } else {
                cnt--;
                p2++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}