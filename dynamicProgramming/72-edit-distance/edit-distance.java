class Solution {
    int dp[][];

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++)
            Arrays.fill(dp[i], -1);
        return helper(word1, word2, 0, 0);
    }

    public int helper(String s1, String s2, int i, int j) {
        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int one = (int) 1e6, two = (int) 1e6;
        if (s1.charAt(i) == s2.charAt(j))
            one = helper(s1, s2, i + 1, j + 1);
        else
            two = 1 + Math.min(helper(s1, s2, i + 1, j),
                    Math.min(helper(s1, s2, i, j + 1), helper(s1, s2, i + 1, j + 1)));
        return dp[i][j] = Math.min(one, two);
    }
}