class Solution {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int rows[] = new int[m];
        int cols[] = new int[n];
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                pq.add(new int[] { i, j, grid[i][j] });
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int val = Math.max(rows[r], cols[c]);

            grid[r][c] = val;

            rows[r] = val + 1;
            cols[c] = val + 1;
        }

        return grid;
    }
}