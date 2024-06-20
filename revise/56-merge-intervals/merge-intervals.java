class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(new int[] { intervals[0][0], intervals[0][1] });
        for (int i = 1; i < intervals.length; i++) {
            int last[] = ans.get(ans.size() - 1);
            if (last[1] >= intervals[i][0]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                ans.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }
        return ans.toArray(new int[0][0]);
    }
}
