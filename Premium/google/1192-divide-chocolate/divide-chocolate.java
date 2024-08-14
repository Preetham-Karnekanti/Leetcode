class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 1;
        int high = 0;
        for (int i : sweetness) {
            high += i;
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(sweetness, k + 1, mid)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public boolean isPossible(int nums[], int persons, int maxSum) {
        int pieces = 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum >= maxSum) {
                pieces++;
                sum = 0;
            }
        }

        return pieces >= persons;
    }
}