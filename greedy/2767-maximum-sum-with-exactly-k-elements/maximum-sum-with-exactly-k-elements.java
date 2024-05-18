class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, nums[i]);
        int ans = max;
        for (int i = 0; i < k - 1; i++) {
            max++;
            ans += max;
        }
        return ans;
    }
}