class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int low = 0;
        int n = nums.length;
        int high = nums.length - 1;
        if (nums[0] < nums[n - 1])
            return nums[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if(nums[mid] < nums[mid - 1])
                return nums[mid];
            else if(nums[mid] > nums[0])
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return -1;
    }
}