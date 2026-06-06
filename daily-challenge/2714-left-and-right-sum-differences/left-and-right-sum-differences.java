class Solution {
    public int[] leftRightDifference(int[] nums) {
        int ans[] = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] + ans[i - 1];
        }
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - sum);
            sum += nums[i];
        }
        return ans;
    }
}