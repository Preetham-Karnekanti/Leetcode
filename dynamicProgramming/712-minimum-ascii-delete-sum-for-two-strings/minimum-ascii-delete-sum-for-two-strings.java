class Solution {
    int dp[][];

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int[] ints : dp)
            Arrays.fill(ints, -1);
        return helper(s1, s2, 0, 0);
    }

    public int helper(String s1, String s2, int i, int j) {
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++)
                sum += (int) s2.charAt(k);
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++)
                sum += (int) s1.charAt(k);
            return sum;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return helper(s1, s2, i + 1, j + 1);
        int cost = (int) 1e9;
        int one = getAscii(s1.charAt(i)) + helper(s1, s2, i + 1, j);
        int two = getAscii(s2.charAt(j)) + helper(s1, s2, i, j + 1);
        cost = Math.min(cost, Math.min(one, two));
        return dp[i][j] = cost;
    }

    public int getAscii(char ch) {
        return (int) ch;
    }
}