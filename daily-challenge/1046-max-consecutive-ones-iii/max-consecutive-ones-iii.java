class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeroCount = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroCount += 1 - nums[i];
            while (zeroCount > k) {
                zeroCount = zeroCount - (1 - nums[left]);
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}