class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        int lsum[] = new int[n];
        int rsum[] = new int[n];
        int sum = boxes.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            lsum[i] = sum + lsum[i - 1];
            sum = sum + boxes.charAt(i) - '0';
        }

        sum = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            rsum[i] = sum + rsum[i + 1];
            sum = sum + boxes.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            ans[i] = lsum[i] + rsum[i];
        }
        return ans;
    }
}