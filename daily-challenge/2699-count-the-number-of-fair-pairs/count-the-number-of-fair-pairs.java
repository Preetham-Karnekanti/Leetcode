class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    public long count(int nums[], int value) {
        int left = 0;
        int right = nums.length - 1;
        long ans = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > value)
                right--;
            else {
                ans += (right - left);
                left++;
            }
        }
        return ans;
    }
}