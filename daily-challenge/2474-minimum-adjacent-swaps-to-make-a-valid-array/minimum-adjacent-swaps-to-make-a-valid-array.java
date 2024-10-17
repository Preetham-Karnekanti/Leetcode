class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int minIdx = n;
        int maxIdx = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= min) {
                if (nums[i] == min) {
                    minIdx = Math.min(minIdx, i);
                } else {
                    minIdx = i;
                }
                min = nums[i];
            }
            if (nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int ans = n - 1 - maxIdx + minIdx;
        if (maxIdx < minIdx)
            ans--;
        return ans;
    }
}