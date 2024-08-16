class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int k = n * 5 / 100;
        int sum = 0;
        for (int i = k; i < n - k; i++) {
            sum = sum + arr[i];
        }
        return (double) sum / (n - 2 * k);
    }
}