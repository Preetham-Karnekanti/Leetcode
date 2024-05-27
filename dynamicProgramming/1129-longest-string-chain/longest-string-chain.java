class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int dp[] = new int[words.length];
        int max = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(words[i], words[j]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean compare(String t, String s) {
        int i = 0;
        int j = 0;

        if (t.length() != s.length() + 1)
            return false;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}