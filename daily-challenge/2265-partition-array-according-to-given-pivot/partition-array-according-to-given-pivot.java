class Solution {
    public int[] pivotArray(int[] arr, int pivot) {
        int ans[] = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot)
                ans[k++] = arr[i];
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot)
                ans[k++] = pivot;
        }
        // for (int i = 0; i < count; i++)
        //     ans[k++] = pivot;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > pivot)
                ans[k++] = arr[i];
        }
        return ans;
    }
}