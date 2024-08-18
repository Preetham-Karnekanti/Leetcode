class Solution {
    public int maxLength(int[] ribbons, int k) {
        int low = 1;
        int high = (int) 1e5 + 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCutPossible(mid, ribbons, k)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public boolean isCutPossible(int mid, int nums[], int k) {
        int count = 0;
        for (int i : nums) {
            count += i / mid;
        }
        return count >= k;
    }
}