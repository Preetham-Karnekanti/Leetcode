class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            maxSoFar = Math.max(maxSoFar, sum);
            sum = Math.max(sum, 0);
        }
        return maxSoFar;
    }
}