class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length + 1];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = Arrays.binarySearch(dp, 0, len, nums[i]);
            if (idx < 0)
                idx = -(idx + 1);
            dp[idx] = nums[i];
            if (idx == len)
                len++;
        }
        return len;
    }
}