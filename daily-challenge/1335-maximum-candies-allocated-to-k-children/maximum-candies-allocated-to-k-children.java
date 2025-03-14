class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        int ans = 0;
        for (int i : candies)
            high = Math.max(high, i);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(candies, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int arr[], int perChild, long total) {
        long count = 0;
        for (int i : arr) {
            count += i / perChild;
        }
        return count >= total;
    }
}