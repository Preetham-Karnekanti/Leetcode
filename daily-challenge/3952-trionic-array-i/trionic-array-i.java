class Solution {
    public boolean isTrionic(int[] nums) {
        int i = 0;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                break;
        }

        if (i == 0 || i == nums.length - 1)
            return false;
        int tempIdx = i;
        for (; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1])
                break;
        }

        if (i == tempIdx || i == nums.length - 1)
            return false;
        tempIdx = i;
        for (;i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                break;
        }
        return i == nums.length - 1;
    }
}