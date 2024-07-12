class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid % 2 == 0 && mid < n - 1 && nums[mid] == nums[mid + 1])
                    || (mid % 2 == 1 && mid >= 0 && nums[mid] == nums[mid - 1]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return nums[low];
    }
}