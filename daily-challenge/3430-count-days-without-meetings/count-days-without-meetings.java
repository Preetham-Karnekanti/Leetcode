class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int count = meetings[0][0] - 1;
        int end = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] > end) {
                count += meetings[i][0] - end - 1;
            }
            end = Math.max(meetings[i][1], end);
        }
        if (end < days) {
            count += days - end;
        }
        return count;
    }
}