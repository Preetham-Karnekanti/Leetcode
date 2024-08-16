class Solution {
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        if (price.length == 1 && maxAmount >= price[0])
            return tastiness[0];
        Integer dp[][][] = new Integer[price.length][maxAmount + 1][maxCoupons + 1];
        return helper(price, tastiness, maxAmount, maxCoupons, 0, dp);
    }

    public int helper(int price[], int tastiness[], int maxAmount, int maxCoupons, int idx, Integer dp[][][]) {
        if (idx == price.length || maxAmount == 0)
            return 0;
        if (dp[idx][maxAmount][maxCoupons] != null)
            return dp[idx][maxAmount][maxCoupons];
        int buyWithoutCoupon = 0;
        int buyWithCoupon = 0;
        int skip = 0;
        if (price[idx] <= maxAmount) {
            buyWithoutCoupon = tastiness[idx]
                    + helper(price, tastiness, maxAmount - price[idx], maxCoupons, idx + 1, dp);
        }
        if (price[idx] / 2 <= maxAmount && maxCoupons > 0) {
            buyWithCoupon = tastiness[idx]
                    + helper(price, tastiness, maxAmount - price[idx] / 2, maxCoupons - 1, idx + 1, dp);
        }
        skip = helper(price, tastiness, maxAmount, maxCoupons, idx + 1, dp);
        return dp[idx][maxAmount][maxCoupons] = Math.max(buyWithoutCoupon, Math.max(buyWithCoupon, skip));
    }
}