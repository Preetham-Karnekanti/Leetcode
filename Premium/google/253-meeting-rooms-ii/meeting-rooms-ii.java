class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for (int i[] : intervals)
            max = Math.max(max, i[1]);
        int prefix[] = new int[max + 1];
        for (int i[] : intervals) {
            int start = i[0];
            int end = i[1];
            prefix[start]++;
            prefix[end]--;
        }
        int min = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
            min = Math.max(min, prefix[i]);
        }
        return min;
    }
}