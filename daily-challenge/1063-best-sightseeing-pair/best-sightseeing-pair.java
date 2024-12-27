class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int maxLeftScore = values[0];
        for (int i = 1; i < values.length; i++) {
            int currentRightScore = values[i] - i;
            max = Math.max(max, currentRightScore + maxLeftScore);
            maxLeftScore = Math.max(maxLeftScore, values[i] + i);
        }
        return max;
    }
}