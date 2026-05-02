class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int sum = 0, F0 = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F0 += i * A[i];
        }
        int prev = F0;
        max = prev;
        for (int i = 1; i < A.length; i++) {
            int cur = prev + sum - A.length * A[A.length - i];
            max = Math.max(max, cur);
            prev = cur;
        }
        return max;
    }
}