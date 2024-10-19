class Solution {
    int dx[] = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
    int dy[] = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int movements[][] = new int[m][n];
        for (int i[] : movements)
            Arrays.fill(i, -1);
        helper(movements, r, c, 0, m, n);
        return movements;
    }

    public boolean helper(int[][] movements, int r, int c, int steps, int m, int n) {
        if (steps == m * n)
            return true;
        if (r < 0 || c < 0 || r >= m || c >= n || movements[r][c] != -1)
            return false;
        movements[r][c] = steps;
        for (int i = 0; i < dx.length; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (helper(movements, nr, nc, steps + 1, m, n))
                return true;
        }
        movements[r][c] = -1;
        return false;
    }
}