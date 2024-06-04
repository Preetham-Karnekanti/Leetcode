class Solution {
    private static int[][] DIR = { { 0, -1 }, { -1, 0 }, { -1, -1 } };
    private static final int mod = (int) 1e9 + 7;

    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int n = board.get(0).length();
        Queue<int[]> q = new ArrayDeque<>();
        int[][] sumDP = new int[m][n];
        int[][] countDP = new int[m][n];
        countDP[m - 1][n - 1] = 1;
        // {row, col}
        int[] ans = { 0, 0 };
        q.offer(new int[] { m - 1, n - 1, 0 });
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0], y = node[1], sum = node[2];
            for (int[] dr : DIR) {
                int i = x + dr[0];
                int j = y + dr[1];
                if (i < 0 || j < 0)
                    continue;
                char ch = board.get(i).charAt(j);
                if (ch == 'X')
                    continue;
                int newSum = ch == 'E' ? sum : sum + ch - '0';
                if (newSum > sumDP[i][j]) {
                    sumDP[i][j] = newSum;
                    countDP[i][j] = countDP[x][y];
                    q.offer(new int[] { i, j, newSum });
                } else if (newSum == sumDP[i][j]) {
                    countDP[i][j] += countDP[x][y];
                    countDP[i][j] %= mod;
                }
            }
        }
        ans[0] = sumDP[0][0];
        ans[1] = countDP[0][0];
        return ans;
    }
}