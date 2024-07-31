class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer dp[] = new Integer[books.length];
        return helper(books, shelfWidth, 0, dp);
    }

    public int helper(int[][] books, int shelfWidth, int idx, Integer[] dp) {
        if (idx == books.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        int min = (int) 1e9, height = 0, width = 0;
        for (int i = idx; i < books.length; i++) {
            width += books[i][0];
            if (width > shelfWidth)
                break;
            height = Math.max(height, books[i][1]);
            min = Math.min(min, height + helper(books, shelfWidth, i + 1, dp));
        }
        return dp[idx] = min;
    }
}