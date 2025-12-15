class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        long streak = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] == -1)
                streak++;
            else {
                ans += (streak * (streak + 1)) / 2;
                streak = 1;
            }
        }
        ans += (streak * (streak + 1)) / 2;
        return ans;
    }
}