public class Solution {
    public int nthUglyNumber(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2 * ugly[++idx2];
            }
            if (factor3 == min) {
                factor3 = 3 * ugly[++idx3];
            }
            if (factor5 == min) {
                factor5 = 5 * ugly[++idx5];
            }
        }
        return ugly[n - 1];
    }
}