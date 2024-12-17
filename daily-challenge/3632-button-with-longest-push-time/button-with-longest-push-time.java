class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int longestTime = events[0][1];
        int finalIndex = events[0][0];

        for (int i = 1; i < events.length; i++) {
            int indx = events[i][0];
            int time = events[i][1];

            int prevTime = events[i - 1][1];

            if (time - prevTime > longestTime) {
                finalIndex = indx;
                longestTime = time - prevTime;
            } else if (time - prevTime == longestTime) {

                finalIndex = Math.min(finalIndex, indx);
            }

        }
        return finalIndex;
    }
}