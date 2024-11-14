class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for (int i : quantities) {
            high = Math.max(high, i);
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(quantities, mid, n)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int quantities[], int max, int n) {
        int count = 0;
        for (int i : quantities) {
            count += Math.ceil(i / (max * 1.0));
            if (count > n)
                return false;
        }
        return true;
    }
}