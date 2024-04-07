class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0;
        while (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == nums.length - 1)
            return 0;
        int j = nums.length - 1;
        while (j - 1 >= 0 && nums[j - 1] <= nums[j]) {
            j--;
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(nums[k], min);
            max = Math.max(nums[k], max);
        }

        while (i - 1 >= 0 && nums[i - 1] > min)
            i--;
        while (j + 1 < nums.length && nums[j + 1] < max)
            j++;
        return j - i + 1;
    }
}