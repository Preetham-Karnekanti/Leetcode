class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int count = 1;
        while (right < nums.length) {
            if (nums[right] - nums[left] > k) {
                left = right;
                count++;
            } else {
                right++;
            }
        }
        return count;
    }
}