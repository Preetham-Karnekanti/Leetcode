class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                count++;
            while (count > k) {
                if (nums[left] == 0)
                    count--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}