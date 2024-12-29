class Solution {
    int m = (int) 1e9 + 7;
    long dp[][];

    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int freq[][] = new int[wordLength][26];
        dp = new long[wordLength][wordLength];
        for (long i[] : dp)
            Arrays.fill(i, -1);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                freq[j][ch - 'a']++;
            }
        }
        return (int) helper(words, freq, target, 0, 0);
    }

    public long helper(String[] words, int freq[][], String target, int wordIdx, int tIdx) {
        if (tIdx == target.length())
            return 1;
        if (wordIdx == words[0].length() || words[0].length() - wordIdx < target.length() - tIdx)
            return 0;
        if (dp[wordIdx][tIdx] != -1)
            return dp[wordIdx][tIdx];
        long ways = 0;
        int cur = target.charAt(tIdx) - 'a';
        ways += helper(words, freq, target, wordIdx + 1, tIdx);
        ways += freq[wordIdx][cur] * helper(words, freq, target, wordIdx + 1, tIdx + 1);
        return dp[wordIdx][tIdx] = ways % m;
    }
}