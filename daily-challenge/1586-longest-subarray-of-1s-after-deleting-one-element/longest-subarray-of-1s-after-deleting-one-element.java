class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        int n = nums.length;
        for (int right = 0; right < n; right++) {
            zeros += 1 - nums[right];
            while (zeros > 1) {
                zeros -= 1 - nums[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen - 1;
    }
}