class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bit = new int[32];
        Arrays.fill(bit, -1);
        int n = nums.length;
        int left = 0;
        int cur = 0;
        int res = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            cur |= nums[right];
            for (int b = 0; b < 32; b++) {
                if ((nums[right] & (1 << b)) != 0) {
                    bit[b] = right;
                }
            }
            while (cur >= k && left <= right) {
                res = Math.min(res, right - left + 1);
                for (int b = 0; b < 32; b++) {
                    if ((nums[left] & (1 << b)) != 0 && bit[b] == left) {
                        bit[b] = -1;
                        cur ^= 1 << b;
                    }
                }
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}