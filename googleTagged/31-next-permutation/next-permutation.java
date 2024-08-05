class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = 0;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(arr, 0, n - 1);
            return;
        }
        int j;
        for (j = n - 1; j > i; j--) {
            if (arr[j] > arr[i])
                break;
        }
        swap(arr, i, j);
        reverse(arr, i + 1, n - 1);
    }

    public void reverse(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}