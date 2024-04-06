class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int low = 0;
        int high = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;

        int ans = 0;
        high = price[n - 1] - price[0];
        while (low <= high) {
            int tastiness = (low + high) / 2;
            if (isPossible(price, tastiness, k)) {
                ans = tastiness;
                low = tastiness + 1;
            } else
                high = tastiness - 1;
        }
        return ans;
    }

    public boolean isPossible(int price[], int tastiness, int k) {
        int prev = price[0];
        int count = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - prev >= tastiness) {
                count++;
                prev = price[i];
            }
        }
        return count >= k;
    }
}