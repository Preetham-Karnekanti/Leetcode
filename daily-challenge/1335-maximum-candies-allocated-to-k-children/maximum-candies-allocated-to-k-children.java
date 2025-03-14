class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = 0;
        long ans = 0;
        for (int i : candies)
            high = Math.max(high, i);
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(candies, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)ans;
    }

    public boolean isPossible(int arr[], long perChild, long total) {
        long count = 0;
        for (int i : arr) {
            count += i / perChild;
        }
        return count >= total;
    }
}