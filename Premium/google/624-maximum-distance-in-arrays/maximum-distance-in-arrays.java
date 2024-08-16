class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        for (int i = 0; i < arrays.size(); i++) {
            int n = arrays.get(i).size();
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(n - 1);
            if (curMin < min) {
                minIdx = i;
                secMin = min;
                min = curMin;
            } else if (curMin < secMin) {
                secMin = curMin;
            }
            if (curMax > max) {
                secMax = max;
                max = curMax;
                maxIdx = i;
            } else if (secMax < curMax) {
                secMax = curMax;
            }
        }
        return maxIdx == minIdx ? Math.max(secMax - min, max - secMin) : max - min;
    }
}