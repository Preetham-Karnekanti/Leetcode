class Solution {
    public long countSubarrays(int[] nums) {
        int right = 0;
        int left = 0;
        long count = 0;
        while (right < nums.length) {
            while (right < nums.length - 1 && nums[right] < nums[right + 1]) {
                right++;
            }
            long len = right - left + 1;
            count += (len * (len + 1)) / 2;
            right++;
            left = right;
        }
        long len = right - left;
        count += (len * (len + 1)) / 2;
        return count;
    }
}