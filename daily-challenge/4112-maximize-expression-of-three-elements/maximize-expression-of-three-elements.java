class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = max;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] >= secondMax && nums[i] <= max) {
                secondMax = nums[i];
            } 
            min = Math.min(min, nums[i]);
        }
        return max + secondMax - min;
    }
}