class Solution {
    Integer dp[][][];

    public int minSteps(int N) {
        dp = new Integer[N + 1][N + 1][2];
        return helper(N, 1, 0, 0);
    }

    public int helper(int n, int i, int copy, int pasteCount) {

        // Base condition of exactly n A's
        if (i == n) {
            return 0;
        }

        // when A's > n return large number to ensure it is not part of our answer
        if (i > n) {
            return 10000;
        }
        if(dp[i][pasteCount][copy] != null)
            return dp[i][pasteCount][copy];

        // Initial State i.e copy = 0
        // choose to copy as paste is not possible
        if (copy == 0) {
            // pasteCount = curr number of A's
            // copy = 1 refers, we can perform paste
            return 1 + helper(n, i, 1, i);
        }
        // Copy = 1
        // choose to paste and retain copy state so that we paste again in future
        int op1 = 1 + helper(n, i + pasteCount, 1, pasteCount);
        // choose to paste and inverse copy state so that we can copy in next step
        int op2 = 1 + helper(n, i + pasteCount, 0, pasteCount);

        return dp[i][pasteCount][copy] = Math.min(op1, op2);
    }

}