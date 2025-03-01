class Solution {
    public int minSwaps(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int curr = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i] == 1 ? 1 : 0;
            if (i >= total) {
                curr -= arr[i - total] == 1 ? 1 : 0;
            }
            max = Math.max(max, curr);
        }
        return total - max;
    }
}
