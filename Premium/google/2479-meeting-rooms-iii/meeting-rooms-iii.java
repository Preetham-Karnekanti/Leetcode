class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        long finishTime[] = new long[n];
        int count[] = new int[n];
        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            long minEnd = Long.MAX_VALUE;
            int minIdx = -1;
            boolean hasEmptyRoom = false;
            for (int j = 0; j < n; j++) {
                if (finishTime[j] < minEnd) {
                    minEnd = finishTime[j];
                    minIdx = j;
                }
                if (finishTime[j] <= start) {
                    finishTime[j] = end;
                    count[j]++;
                    hasEmptyRoom = true;
                    break;
                }
            }
            if (hasEmptyRoom == false) {
                finishTime[minIdx] += (end - start);
                count[minIdx]++;
            }
        }
        int max = 0;
        int roomNo = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                roomNo = i;
            }
        }
        System.out.println(Arrays.toString(finishTime));
        return roomNo;
    }
}