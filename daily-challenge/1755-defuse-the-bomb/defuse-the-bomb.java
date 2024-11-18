class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
            } else {
                for (int j = 1; j <= -1 * k; j++) {
                    sum += code[(i - j + code.length) % code.length];
                }
            }
            ans[i] = sum;
        }

        return ans;
    }
}