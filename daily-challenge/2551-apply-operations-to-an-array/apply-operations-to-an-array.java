class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int left = 0;
        int right = 0;
        for (right = 0; right < n; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        for (;left < n; left++)
            nums[left] = 0;
        return nums;
    }
}