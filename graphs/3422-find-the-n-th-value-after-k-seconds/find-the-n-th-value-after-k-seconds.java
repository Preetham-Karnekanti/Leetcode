class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int arr[] = new int[n];
        int m = (int) 1e9 + 7;
        Arrays.fill(arr, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; i++)
                arr[i] = (arr[i - 1] + arr[i]) % m;
        }
        return arr[n - 1];
    }
}