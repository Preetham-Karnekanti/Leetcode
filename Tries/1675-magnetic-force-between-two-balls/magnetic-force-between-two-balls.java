class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int ans = 0;
        int high = (position[n - 1] - position[0]) / (m - 1);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(position, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int arr[], int m, int distance) {
        int prev = arr[0];
        int ballsPlaced = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= distance) {
                ballsPlaced++;
                prev = arr[i];
            }
            if (ballsPlaced >= m)
                return true;
        }
        return false;
    }
}