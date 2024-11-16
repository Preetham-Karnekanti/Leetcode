class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[n - k + 1];
        Arrays.fill(arr, -1);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int idx = 0;
        if (isSorted(sum, nums[0], k)) {
            arr[idx] = nums[k - 1];
        }
        idx++;
        int left = 0;
        for (int i = k; i < n; i++) {
            sum -= nums[left++];
            sum += nums[i];
            if (isSorted(sum, nums[left], k) && nums[i] - nums[i - k + 1] + 1 == k)
                arr[idx] = nums[i];
            idx++;
        }
        return arr;
    }

    public boolean isSorted(int sum, int first, int k) {
        int sum2 = 2 * first + (k - 1);
        sum2 = sum2 * k / 2;
        return sum == sum2;
    }
}