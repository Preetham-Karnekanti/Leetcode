class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int count = 0;
        count = meetings[0][0] - 1;
        int end = meetings[0][1];
        System.out.println(count);

        for (int i = 1; i < meetings.length; i++) {
            if (end < meetings[i][0]) {
                count += meetings[i][0] - end - 1;
            }
            end = Math.max(meetings[i][1], end);
        }
        int n = meetings.length;
        if (end < days) {
            count = count + days - end;
        }
        return count;
    }
}