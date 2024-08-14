class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countDifferencesWithMid(mid, nums);
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public int countDifferencesWithMid(int diff, int nums[]) {
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (left < right && nums[right] - nums[left] > diff)
                left++;
            count += right - left;
            right++;
        }
        return count;
    }
}