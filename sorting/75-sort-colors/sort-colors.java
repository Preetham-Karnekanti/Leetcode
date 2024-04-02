class Solution {
    public void sortColors(int[] input) {
        int low = 0;
        int high = input.length - 1;
        int mid = 0;
        while (mid <= high) {
            if (input[mid] == 0) {
                swap(input, mid++, low++);
            } else if (input[mid] == 2) {
                swap(input, mid, high--);
            } else {
                mid++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}