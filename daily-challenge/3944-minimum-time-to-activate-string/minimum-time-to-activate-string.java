class Solution {

    public int minTime(String s, int[] order, int k) {
        int n = s.length();

        long totalSubstrings = (long) n * (n + 1) / 2;

        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(order, mid, n, totalSubstrings, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] order, int t,
                               int n, long total, int k) {

        boolean[] removed = new boolean[n];

        // Mark '*' positions
        for (int i = 0; i <= t; i++) {
            removed[order[i]] = true;
        }

        long invalid = 0;
        int len = 0;

        // Count contiguous non-* segments
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                len++;
            } else {
                invalid += (long) len * (len + 1) / 2;
                len = 0;
            }
        }

        // last segment
        invalid += (long) len * (len + 1) / 2;

        long valid = total - invalid;

        return valid >= k;
    }
}