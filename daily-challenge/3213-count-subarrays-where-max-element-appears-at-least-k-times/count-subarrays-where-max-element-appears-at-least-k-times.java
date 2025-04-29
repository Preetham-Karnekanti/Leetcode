class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int right = 0, left = 0;
        int maxCount = 0;
        long ans = 0;
        int n = nums.length;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == max)
                maxCount++;
            while (left <= right && maxCount >= k) {
                ans += n - right;
                if (nums[left] == max)
                    maxCount--;
                left++;
            }
        }
        return ans;
    }
}