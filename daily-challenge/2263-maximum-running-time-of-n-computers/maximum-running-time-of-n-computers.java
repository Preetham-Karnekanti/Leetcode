class Solution {
    public long maxRunTime(int n, int[] nums) {
        long low = 1;
        long high = 0;
        for (int i = 0; i < nums.length; i++)
            high += nums[i];
        long ans = 0;
        while (low <= high) {
            long minutes = low + (high - low) / 2;
            if (isPossbileToRunAllWithCurMin(minutes, nums, n)) {
                ans = minutes;
                low = minutes + 1;

            } else
                high = minutes - 1;
        }
        return ans;
    }

    public boolean isPossbileToRunAllWithCurMin(long minutes, int[] nums, int n) {
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += Math.min(minutes, nums[i]);
        }
        return count >= minutes * n;
    }
}