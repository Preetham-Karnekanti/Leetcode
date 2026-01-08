class Solution {
    Integer dp[][];

    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return helper(nums1, nums2, 0, 0);
    }

    public int helper(int nums1[], int nums2[], int i, int j) {
        if (i == nums1.length || j == nums2.length)
            return -(int) 1e9;
        if (dp[i][j] != null)
            return dp[i][j];
        int take = nums1[i] * nums2[j];
        take = Math.max(take, take + helper(nums1, nums2, i + 1, j + 1));
        int skip = Math.max(helper(nums1, nums2, i + 1, j), helper(nums1, nums2, i, j + 1));
        return dp[i][j] = Math.max(take, skip);
    }
}