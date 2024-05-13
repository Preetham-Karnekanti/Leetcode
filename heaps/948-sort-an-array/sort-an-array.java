class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergesort(int[] nums, int low, int high) {
        if (low == high)
            return;
        int mid = low + (high - low) / 2;
        mergesort(nums, low, mid);
        mergesort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public void merge(int nums[], int low, int m, int high) {
        int i = low;
        int j = m + 1;
        int a[] = new int[high - low + 1];
        int k = 0;

        while (i <= m && j <= high) {
            if (nums[i] < nums[j]) {
                a[k++] = nums[i++];
            } else
                a[k++] = nums[j++];
        }
        while (i <= m) {
            a[k++] = nums[i++];
        }
        while (j <= high) {
            a[k++] = nums[j++];
        }
        int x = 0;
        for (int c = low; c <= high; c++)
            nums[c] = a[x++];
    }
}