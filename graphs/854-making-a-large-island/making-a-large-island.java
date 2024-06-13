class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    int newr = i + dx[k];
                    int newc = j + dy[k];
                    if (!isValid(newr, newc, n) || grid[newr][newc] == 0)
                        continue;
                    int nodeNo = i * n + j;
                    int adjNode = newr * n + newc;
                    ds.unionBySize(nodeNo, adjNode);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;
                HashSet<Integer> hs = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int newr = i + dx[k];
                    int newc = j + dy[k];
                    if (!isValid(newr, newc, n) || grid[newr][newc] == 0)
                        continue;
                    hs.add(ds.findParent(newr * n + newc));
                }
                int count = 0;
                for (int c : hs) {
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
    int[] parent, size;

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

    public void unionBySize(int u, int v) {
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