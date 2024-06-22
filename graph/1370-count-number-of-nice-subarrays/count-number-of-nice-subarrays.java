class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int oddCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1)
                oddCount++;
            while (oddCount > k) {
                if (nums[left] % 2 == 1)
                    oddCount--;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}