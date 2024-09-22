class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long high = (long) 1e18;
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mountainHeight, workerTimes, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isPossible(long mountainHeight, int nums[], long maxTime) {
        long totalReduction = 0;

        for (int v : nums) {
            long maxHeight = (long) (-1 + Math.sqrt(1 + 8 * maxTime / v)) / 2;
            totalReduction += maxHeight;
            if (totalReduction >= mountainHeight) {
                return true;
            }
        }
        return totalReduction >= mountainHeight;
    }
}