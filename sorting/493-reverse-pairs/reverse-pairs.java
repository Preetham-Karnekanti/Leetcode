class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergesort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergesort(nums, low, mid);
        mergesort(nums, mid + 1, high);
        helper(nums, low, mid, high);
        merge(nums, low, mid, high);
    }

    public void merge(int nums[], int low, int mid, int high) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] > nums[j]) {
                al.add(nums[j++]);
            } else {
                al.add(nums[i++]);
            }
        }
        while (i <= mid) {
            al.add(nums[i++]);
        }
        while (j <= mid) {
            al.add(nums[j++]);
        }
        for (i = 0; i < al.size(); i++) {
            nums[low + i] = al.get(i);
        }
    }

    public void helper(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            while (i <= mid && j <= high && arr[i] > (long) 2 * arr[j]) {
                count = count + mid - i + 1;
                j++;
            }
            i++;
        }
    }
}