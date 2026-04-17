class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            curSum += i;
            max = Math.max(max, curSum);
            curSum = Math.max(curSum, 0);
        }
        return max;
    }
}