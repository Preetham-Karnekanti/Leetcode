class Solution {
    public int largestCombination(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 24; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += checkbit(nums[j], i);
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public int checkbit(int num, int i) {
        num >>= i;
        return num & 1;
    }
}