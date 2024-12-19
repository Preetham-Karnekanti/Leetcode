class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = nums.length + 1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                size = Math.min(size, right - left + 1);
                sum -= nums[left++];
            }
        }
        return size == nums.length + 1 ? 0 : size;
    }
}