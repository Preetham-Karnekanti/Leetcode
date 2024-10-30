class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp1[j] > dp1[i])
                    dp1[i] = 1 + dp1[j];
            }
        }
        int n = nums.length;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && 1 + dp2[j] > dp2[i])
                    dp2[i] = 1 + dp2[j];
            }

        }
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1)
                max = Math.max(max, dp1[i] + dp2[i]);
        }
        return n - max + 1;
    }
}