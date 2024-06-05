class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int dp[] = new int[envelopes.length + 1];
        int len = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int ind = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
            if (ind < 0)
                ind = -(ind + 1);
            dp[ind] = envelopes[i][1];
            if (len == ind)
                len++;
        }
        return len++;
    }
}