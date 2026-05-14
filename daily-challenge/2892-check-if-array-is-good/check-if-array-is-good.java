class Solution {
    public boolean isGood(int[] nums) {
        if (nums.length == 1)
            return false;
        int n = nums.length;
        Arrays.sort(nums);
        if (n - 1 != nums[n - 1] || nums[n - 1] != nums[n - 2])
            return false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1)
                return false;
        }
        return true;
    }
}