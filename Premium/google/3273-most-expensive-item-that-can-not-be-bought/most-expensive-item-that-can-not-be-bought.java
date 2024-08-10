class Solution {
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        int res = 0;
        Boolean dp[] = new Boolean[primeOne * primeTwo + 1];
        for (int i = primeOne * primeTwo; i >= 0; i--) {
            if (isPossible(i, primeOne, primeTwo, dp) == false) {
                return i;
            }
        }
        return res;
    }

    public boolean isPossible(int num, int a, int b, Boolean[] dp) {
        if (num == 0)
            return true;
        if (num < 0)
            return false;
        if (dp[num] != null)
            return dp[num];
        return dp[num] = isPossible(num - a - b, a, b, dp) || isPossible(num - a, a, b, dp)
                || isPossible(num - b, a, b, dp);
    }
}