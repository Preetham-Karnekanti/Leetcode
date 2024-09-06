class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int n = stockPrices.length;
        if (n == 1)
            return 0;
        int cnt = 1;
        for (int i = 0; i + 2 < n; i++) {
            int dx2x1 = stockPrices[i + 1][0] - stockPrices[i][0];
            int dx3x2 = stockPrices[i + 2][0] - stockPrices[i + 1][0];
            int dy2y1 = stockPrices[i + 1][1] - stockPrices[i][1];
            int dy3y2 = stockPrices[i + 2][1] - stockPrices[i + 1][1];

            if (dy3y2 * dx2x1 != dy2y1 * dx3x2)
                cnt++;
        }
        return cnt;
    }
}