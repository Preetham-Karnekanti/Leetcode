class Solution {
    public int largestIsland(int[][] grid) {
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                int node = i * n + j;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if (!isValid(nr, nc, n) || grid[nr][nc] == 0)
                        continue;
                    int adjNode = nr * n + nc;
                    ds.union(node, adjNode);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;
                HashSet<Integer> parents = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if (!isValid(nr, nc, n) || grid[nr][nc] == 0)
                        continue;
                    int adjNode = nr * n + nc;
                    parents.add(ds.findParent(adjNode));
                }
                int count = 0;
                for (int c : parents) {
                    count += ds.size[c];
                }
                max = Math.max(max, count + 1);
            }
        }
        return max == 0 ? n * n : max;
    }

    public boolean isValid(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
}

class DisjointSet {
    int size[];
    int parent[];

    DisjointSet(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

    }
}