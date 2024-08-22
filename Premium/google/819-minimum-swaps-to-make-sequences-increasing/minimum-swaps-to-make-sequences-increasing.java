class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][2];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(nums1, nums2, 0, 0, dp);
    }

    public int helper(int nums1[], int nums2[], int idx, int isSwapped, int[][] dp) {
        if (idx == nums1.length)
            return 0;
        int one = (int) 1e8;
        if (dp[idx][isSwapped] != -1)
            return dp[idx][isSwapped];
        if (idx == 0 || nums1[idx] > nums1[idx - 1] && nums2[idx] > nums2[idx - 1]) {
            one = helper(nums1, nums2, idx + 1, 0, dp);
        }
        swap(nums1, nums2, idx);
        int two = (int) 1e8;
        if (idx == 0 || nums1[idx] > nums1[idx - 1] && nums2[idx] > nums2[idx - 1] && nums1[idx] != nums2[idx])
            two = 1 + helper(nums1, nums2, idx + 1, 1, dp);
        swap(nums1, nums2, idx);
        return dp[idx][isSwapped] = Math.min(one, two);
    }

    public void swap(int nums1[], int nums2[], int idx) {
        int temp = nums1[idx];
        nums1[idx] = nums2[idx];
        nums2[idx] = temp;
    }
}