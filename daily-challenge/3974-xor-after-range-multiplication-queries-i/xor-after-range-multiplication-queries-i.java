class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int m = (int) 1e9 + 7;
        for (int q[] : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            while (l <= r) {
                nums[l] = (int)(((long)nums[l] * v) % m);
                l += k;
            }
        }
        int ans = 0;
        for (int i : nums)
            ans ^= i;
        return ans;
    }
}