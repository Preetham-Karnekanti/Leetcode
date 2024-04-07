class Solution {
    public void nextPermutation(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }
        if (i < 0) {
            reverse(nums, 0, nums.length);
            return;
        }

        for (j = n - 1; j > i; j--) {
            if (nums[j] > nums[i])
                break;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length);
    }

    public void reverse(int nums[], int i, int j) {
        while (i < j) {
            swap(nums, i, j - 1);
            i++;
            j--;
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}