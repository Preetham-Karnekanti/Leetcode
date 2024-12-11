class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int right = binarySearch(nums, nums[i] + 2 * k);
            max = Math.max(max, right - i + 1);
        }

        return max;
    }

    public int binarySearch(int nums[], int val) {
        int low = 0;
        int high = nums.length - 1;
        int idx = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= val) {
                idx = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return idx;
    }
}