class Solution {
    int dx[] = { -1, 1, 0, 0 };
    int dy[] = { 0, 0, -1, 1 };

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1')
                    count += dfs(grid, i, j);
            }
        }
        return count;
    }

    public int dfs(char[][] grid, int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.x;
            int c = p.y;
            grid[i][j] = '0';

            for (int k = 0; k < dx.length; k++) {
                int newX = r + dx[k];
                int newY = c + dy[k];
                if (!isValid(newX, newY, grid) || grid[newX][newY] == '0')
                    continue;
                q.add(new Pair(newX, newY));
                grid[newX][newY] = '0';
            }
        }
        return 1;
    }

    public boolean isValid(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        return true;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}