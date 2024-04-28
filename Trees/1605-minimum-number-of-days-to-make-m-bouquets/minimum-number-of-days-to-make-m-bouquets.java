class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k)
            return -1;
        long ans = -1;
        int minDays = 0;
        int maxDays = 0;
        long requiredFlowers = m * k;
        for (int i : bloomDay) {
            minDays = Math.min(minDays, i);
            maxDays = Math.max(maxDays, i);
        }
        while (minDays <= maxDays) {
            int days = minDays + (maxDays - minDays) / 2;
            if (isPossibleWithinCurrDays(days, bloomDay, m, k)) {
                ans = days;
                maxDays = days - 1;
            } else
                minDays = days + 1;
        }
        return (int) ans;
    }

    public boolean isPossibleWithinCurrDays(int days, int[] nums, int m, int k) {
        long adjacent = 0;
        long b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= days) {
                adjacent++;
            }
            if (adjacent == k) {
                adjacent = 0;
                b++;
            }
            if (nums[i] > days) {
                adjacent = 0;
            }

        }
        return b >= m;
    }
}