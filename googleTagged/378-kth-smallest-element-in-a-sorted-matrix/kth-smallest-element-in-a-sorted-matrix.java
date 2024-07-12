class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = countElementsLessThanMid(mid, matrix);
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public int countElementsLessThanMid(int value, int grid[][]) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && grid[i][j] > value)
                j--;
            count += j + 1;
        }
        return count;
    }
}