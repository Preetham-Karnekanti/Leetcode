class Solution {
    public int maximumCount(int[] nums) {
        int neg = searchNeg(nums);
        int pos = searchPos(nums);
        if (neg == -1 && pos == -1)
            return 0;
        if (pos == -1)
            return neg + 1;
        neg = neg + 1;
        pos = nums.length - pos;
        return Math.max(neg, pos);
    }

    public int searchNeg(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= 0) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public int searchPos(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= 0) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}