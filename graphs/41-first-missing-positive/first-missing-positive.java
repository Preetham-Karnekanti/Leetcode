class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne)
            return 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - 1) % n;
            nums[idx] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                return i + 1;
        }
        return n + 1;
    }
}