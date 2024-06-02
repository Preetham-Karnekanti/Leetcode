class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int i : nums) {
            high += i;
            low = Math.max(low, i);
        }
        int ans = 0;
        while (low <= high) {
            int sum = (low + high) / 2;
            if (isPossibleToPartition(sum, nums, k)) {
                ans = sum;
                high = sum - 1;
            } else
                low = sum + 1;
        }
        return ans;
    }

    public boolean isPossibleToPartition(int sum, int[] nums, int k) {
        int partitions = 1;
        int sumSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumSoFar + nums[i] <= sum) {
                sumSoFar += nums[i];
            } else {
                sumSoFar = nums[i];
                partitions++;
            }
        }
        return partitions <= k;
    }
}