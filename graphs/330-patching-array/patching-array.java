class Solution {
    public int minPatches(int[] nums, int n) {
        long ans = 0, sum = 0;
        for (int i = 0; i < nums.length && sum < n; i++) {
            if (nums[i] <= sum + 1) {
                sum += nums[i];
            } else {
                i--;
                ans++;
                sum = sum * 2 + 1;
            }
        }
        while (sum < n) {
            sum = sum * 2 + 1;
            ans++;
        }
        return (int) ans;
    }
}