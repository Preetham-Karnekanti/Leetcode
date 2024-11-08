class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int pow2 = (int) Math.pow(2, maximumBit);
        int prefix[] = new int[nums.length];
        int ans[] = new int[nums.length];
        prefix[0] = nums[0];
        int n = nums.length;
        for (int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i - 1] ^ nums[i];
        for (int i = 0; i < nums.length; i++) {
            int k = findK(prefix[i], pow2);
            ans[n - i - 1] = k;
        }

        return ans;
    }

    public int findK(int num, int pow) {
        return num ^ pow - 1;
    }
}