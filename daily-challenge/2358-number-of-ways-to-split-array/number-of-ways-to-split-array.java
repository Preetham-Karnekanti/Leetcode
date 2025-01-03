class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int count = 0;
        long curSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curSum += nums[i];
            long remainingSum = totalSum - curSum;
            if (curSum >= remainingSum)
                count++;
        }
        return count;
    }
}