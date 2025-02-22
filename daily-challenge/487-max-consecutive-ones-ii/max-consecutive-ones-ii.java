class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            zeroCount += 1 - nums[right];
            while (left <= right && zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}