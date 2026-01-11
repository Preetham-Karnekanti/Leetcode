class Solution {
    Integer dp[][];

    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length()][s2.length()];
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
        if (dp[i][j] != null)
            return dp[i][j];
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j))
            one = helper(s1, s2, i + 1, j + 1);
        else {
            two = (int) s1.charAt(i) + (int) s2.charAt(j) + helper(s1, s2, i + 1, j + 1);
            two = Math.min(two, (int) s1.charAt(i) + helper(s1, s2, i + 1, j));
            two = Math.min(two, (int) s2.charAt(j) + helper(s1, s2, i, j + 1));
        }
        return dp[i][j] = Math.min(one, two);
    }
}