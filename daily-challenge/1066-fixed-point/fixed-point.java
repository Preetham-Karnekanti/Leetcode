class Solution {
    public int fixedPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == mid) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}