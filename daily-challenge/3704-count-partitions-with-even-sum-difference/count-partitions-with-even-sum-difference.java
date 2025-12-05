class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            if ((leftSum - rightSum) % 2 == 0)
                ans++;
        }
        return ans;
    }
}