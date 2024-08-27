/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * int move(char direction);
 * boolean isTarget();
 * }
 */

class Solution {
    char forward[] = new char[] { 'U', 'D', 'L', 'R' };
    char backward[] = new char[] { 'D', 'U', 'R', 'L' };
    int dx[] = new int[] { 1, -1, 0, 0 };
    int dy[] = new int[] { 0, 0, 1, -1 };
    int target[];

    public int findShortestPath(GridMaster master) {
        int grid[][] = new int[201][201];
        for (int i[] : grid)
            Arrays.fill(i, -1);
        target = new int[2];
        dfs(100, 100, grid, master);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean vis[][] = new boolean[201][201];
        vis[100][100] = true;
        pq.add(new int[] { 100, 100, 0 });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];
            if (r == target[0] && c == target[1])
                return cost;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (vis[nr][nc] || grid[nr][nc] == -1 || grid[nr][nc] == 0)
                    continue;
                pq.add(new int[] { nr, nc, cost + grid[nr][nc] });
                vis[nr][nc] = true;
            }
        }
        return -1;
    }

    public void dfs(int x, int y, int[][] grid, GridMaster master) {
        if (master.isTarget()) {
            target[0] = x;
            target[1] = y;
        }
        for (int i = 0; i < 4; i++) {
            int nr = x + dx[i];
            int nc = y + dy[i];
            char fd = forward[i];
            char bd = backward[i];
            if (master.canMove(fd) && grid[nr][nc] == -1) {
                grid[nr][nc] = master.move(fd);
                dfs(nr, nc, grid, master);
                master.move(bd);
            }
        }
    }
}