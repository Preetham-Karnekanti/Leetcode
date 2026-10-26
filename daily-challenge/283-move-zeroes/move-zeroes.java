class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        int nonZeroIdx = 0;
        for (nonZeroIdx = 0; nonZeroIdx < nums.length; nonZeroIdx++) {
            if (nums[nonZeroIdx] != 0) {
                nums[zeroIdx++] = nums[nonZeroIdx];
            }
        }
        for (int i = zeroIdx; i < nums.length; i++)
            nums[i] = 0;
    }
}
