class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            int xor = 0;
            for (int j = 0; j < n; j++) {
                if (checkbit(i, j)) {
                    xor ^= nums[j];
                }
            }
            ans += xor;
        }
        return ans;
    }

    public boolean checkbit(int num, int i) {
        num = num >> i;
        if ((num & 1) == 1)
            return true;
        return false;
    }
}