class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                int maxLen = 1;
                while (i + 1 < nums.length && nums[i + 1] == max) {
                    i++;
                    maxLen++;
                }
                ans = Math.max(ans, maxLen);
            }
        }
        return ans;
    }
}