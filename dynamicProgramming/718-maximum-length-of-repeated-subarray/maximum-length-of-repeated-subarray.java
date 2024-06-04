class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int prev[] = new int[m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int cur[] = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    cur[j] = prev[j - 1] + 1;
                else
                    cur[j] = 0;
                ans = Math.max(ans, cur[j]);
            }
            prev = cur;
        }
        return ans;
    }
}