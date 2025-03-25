class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long one = 0;
        long two = k;
        for (int i = 0; i < arr.length; i++) {
            one += Math.abs(arr[i] - brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for (int i = 0; i < arr.length; i++)
            two += Math.abs(arr[i] - brr[i]);
        return Math.min(one, two);
    }
}