class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                continue;
            int j = i;
            while (j < nums.length && nums[j] == 0)
                j++;
            long len = j - i;
            long subarrays = len * (len + 1) / 2;
            ans += subarrays;
            i = j - 1;
        }
        return ans;
    }
}