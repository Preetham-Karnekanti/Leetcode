class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[low];
        int ans = 0;
        while (low <= high) {
            int diff = low + (high - low) / 2;
            if (countPairsWithDistanceDiff(diff, nums, k)) {
                ans = diff;
                high = diff - 1;
            } else
                low = diff + 1;
        }
        return ans;
    }

    public boolean countPairsWithDistanceDiff(int diff, int nums[], int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (left < right && nums[right] - nums[left] > diff)
                left++;
            count += right - left;
            right++;
        }
        return count >= k;
    }
}