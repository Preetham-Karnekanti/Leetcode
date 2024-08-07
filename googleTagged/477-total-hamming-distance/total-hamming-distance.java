class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += getBit(nums[j], i);
            }
            ans = ans + (count * (n - count));
        }
        return ans;
    }

    public int getBit(int num, int i) {
        num = num >> i;
        return (num & 1);
    }
}