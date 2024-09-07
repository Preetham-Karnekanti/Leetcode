class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int ans[] = new int[k];
        int idx = 0;
        for (int i = maxIdx; i < maxIdx + k; i++) {
            ans[idx++] = nums[i];
        }
        return ans;
    }
}