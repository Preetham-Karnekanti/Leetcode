class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int time[] = new int[(int) 1e5 + 1];
        int max = events[0][1];
        int idx = events[0][0];
        time[idx] = events[0][1];
        for (int i = 1; i < events.length; i++) {
            int curIdx = events[i][0];
            time[curIdx] = Math.max(time[curIdx], events[i][1] - events[i - 1][1]);
            if (time[curIdx] >= max) {
                if (time[curIdx] > max) {
                    max = time[curIdx];
                    idx = curIdx;
                } else {
                    idx = Math.min(idx, curIdx);
                }
            }
        }
        return idx;
    }
}