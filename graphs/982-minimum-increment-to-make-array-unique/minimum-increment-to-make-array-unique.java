class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int next = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < next) {
                ans += next - nums[i];
                next++;
            } else {
                next = nums[i] + 1;
            }
        }
        return ans;
    }
}