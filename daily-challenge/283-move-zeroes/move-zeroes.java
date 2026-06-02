class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        int nonZeroIdx = 0;
        while (nonZeroIdx < nums.length) {
            if (nums[nonZeroIdx] != 0) {
                nums[zeroIdx++] = nums[nonZeroIdx];
            }
            nonZeroIdx++;
        }
        for (int i = zeroIdx; i < nums.length; i++)
            nums[i] = 0;
    }
}
