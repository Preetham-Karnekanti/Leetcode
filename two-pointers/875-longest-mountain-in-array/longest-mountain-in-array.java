class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3)
            return 0;
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int j = i - 1;
                while (j > 0 && arr[j - 1] < arr[j]) {
                    j--;
                }
                int k = i + 1;
                while (k < arr.length - 1 && arr[k] > arr[k + 1])
                    k++;
                res = Math.max(res, k - j + 1);
            }
        }
        return res;
    }
}