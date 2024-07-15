class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double sum = 0;
        double max = Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (right - left + 1 > k) {
                sum -= nums[left++];
            }
            if (right - left + 1 == k) {
                max = Math.max(max, sum);
            }
        }
        return max / k;
    }
}