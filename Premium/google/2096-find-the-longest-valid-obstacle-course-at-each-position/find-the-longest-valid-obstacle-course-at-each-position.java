class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int ans[] = new int[n];
        int lis[] = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int idx = bisectRight(lis, obstacles[i], len);
            if (idx < 0)
                idx = -(idx + 1);
            if (idx == len)
                len++;
            lis[idx] = obstacles[i];
            ans[i] = idx + 1;
        }
        return ans;
    }
    private int bisectRight(int[] A, int target, int right) {
        if (right == 0)
            return 0;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}