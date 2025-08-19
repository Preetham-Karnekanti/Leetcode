class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count = 0;
            } else {
                count++;
                ans += count;
            }
        }
        return ans;
    }
}