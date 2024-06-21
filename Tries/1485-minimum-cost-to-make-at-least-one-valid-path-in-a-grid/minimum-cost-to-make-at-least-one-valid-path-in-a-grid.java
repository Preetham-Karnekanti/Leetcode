class Solution {
    public int minCost(int[][] grid) {
        int directions[] = new int[] { 1, 2, 3, 4 };
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] distance = new int[n][m];
        for (int i[] : distance)
            Arrays.fill(i, (int) 1e9);
        distance[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int steps = cur[0];
            int r = cur[1];
            int c = cur[2];
            int next[] = getNextDirection(r, c, grid[r][c]);
            int nr = next[0];
            int nc = next[1];
            if (isValid(nr, nc, n, m) && steps < distance[nr][nc]) {
                distance[nr][nc] = steps;
                pq.add(new int[] { steps, next[0], next[1] });
            }
            for (int dir : directions) {
                if (dir != grid[r][c]) {
                    next = getNextDirection(r, c, dir);
                    nr = next[0];
                    nc = next[1];
                    if (isValid(nr, nc, n, m) && 1 + steps < distance[nr][nc]) {
                        distance[nr][nc] = 1 + steps;
                        pq.add(new int[] { 1 + steps, nr, nc });
                    }
                }
            }
        }
        return distance[n - 1][m - 1];
    }

    public int[] getNextDirection(int r, int c, int direction) {
        switch (direction) {
            case 1:
                return new int[] { r, c + 1 };
            case 2:
                return new int[] { r, c - 1 };
            case 3:
                return new int[] { r + 1, c };
            case 4:
                return new int[] { r - 1, c };
            default:
                return new int[] { -1, -1 };
        }
    }

    public boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c)
            return false;
        return true;
    }
}