class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is non-decreasing, return 0
        if (left == n - 1) {
            return 0;
        }

        // Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // The result is the minimum of removing the suffix or the prefix
        int result = Math.min(n - left - 1, right);

        // Try to merge the prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        // If we can't merge, we need to remove the entire suffix
        if (i <= left) {
            result = Math.min(result, n - left - 1);
        }

        return result;
    }
}