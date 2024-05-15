class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> {
            if (a.distance != b.distance)
                return a.distance - b.distance;
            if (a.price != b.price)
                return a.price - b.price;
            if (a.row != b.row)
                return a.row - b.row;
            return a.col - b.col;
        });
        bfs(pq, start[0], start[1], grid, pricing[0], pricing[1]);
        while (!pq.isEmpty() && k-- > 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(pq.peek().row);
            temp.add(pq.peek().col);
            ans.add(temp);
            pq.poll();
        }
        return ans;
    }

    public void bfs(PriorityQueue<Info> pq, int i, int j, int[][] grid, int low, int high) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j, 0 });
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[i][j] >= low && grid[i][j] <= high)
            pq.add(new Info(0, grid[i][j], i, j));
        grid[i][j] = 0;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = row + dx[k];
                int nc = col + dy[k];
                if (!isValid(nr, nc, rows, cols) || grid[nr][nc] == 0)
                    continue;
                if (grid[nr][nc] >= low && grid[nr][nc] <= high) {
                    pq.add(new Info(cur[2] + 1, grid[nr][nc], nr, nc));
                }
                q.add(new int[] { nr, nc, cur[2] + 1 });
                grid[nr][nc] = 0;
            }
        }
    }

    public boolean isValid(int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c)
            return false;
        return true;
    }
}

class Info {
    int distance;
    int price;
    int row;
    int col;

    Info(int d, int p, int r, int c) {
        this.distance = d;
        this.price = p;
        this.row = r;
        this.col = c;
    }
}