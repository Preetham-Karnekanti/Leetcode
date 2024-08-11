class Solution {
    public int findBestValue(int[] arr, int target) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < arr.length; i++)
            high = Math.max(high, arr[i]);
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = getSum(arr, mid);
            if (sum <= target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += Math.min(arr[i], low);
            sum2 += Math.min(arr[i], low - 1);
        }
        return Math.abs(sum2 - target) <= Math.abs(sum1 - target) ? low - 1 : low;
    }

    public int getSum(int arr[], int value) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < value)
                sum += arr[i];
            else
                sum += value;
        }
        return sum;
    }
}