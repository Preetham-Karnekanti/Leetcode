class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        DisjointSet ds = new DisjointSet(row * col + 2);
        int grid[][] = new int[row][col];
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        for (int i = cells.length - 1; i >= 0; i--) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            int curNode = r * col + c;
            grid[r][c] = 1;
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (!isValid(nr, nc, row, col) || grid[nr][nc] == 0)
                    continue;
                int adjNode = nr * col + nc;
                ds.union(curNode, adjNode);
            }
            if (r == 0) {
                ds.union(0, curNode);
            }
            if (r == row - 1) {
                ds.union(row * col, curNode);
            }
            if (ds.findParent(0) == ds.findParent(row * col))
                return i;
        }
        return -1;
    }

    public boolean isValid(int r, int c, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m)
            return false;
        return true;
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}