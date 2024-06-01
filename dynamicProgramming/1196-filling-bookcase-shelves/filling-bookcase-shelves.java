class Solution {
    Integer dp[];

    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new Integer[books.length];
        return helper(books, shelfWidth, 0);
    }

    public int helper(int books[][], int shelfWidth, int idx) {
        if (idx == books.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        int ans = (int) 1e7, width = 0, height = 0;
        for (int i = idx; i < books.length; i++) {
            width += books[i][0];
            if (width > shelfWidth)
                break;
            height = Math.max(height, books[i][1]);
            ans = Math.min(ans, height + helper(books, shelfWidth, i + 1));
        }
        return dp[idx] = ans;
    }
}