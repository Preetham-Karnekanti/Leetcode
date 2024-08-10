class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int matrix[][] = new int[m][n];
        DisjointSet ds = new DisjointSet((m * n) + 1);
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        for (int position[] : positions) {
            int r = position[0];
            int c = position[1];
            if (matrix[r][c] == 1) {
                ans.add(count);
                continue;
            }
            matrix[r][c] = 1;
            count++;
            int node = r * n + c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, m, n) || matrix[nr][nc] == 0)
                    continue;
                int adjNode = nr * n + nc;
                if (ds.findParent(node) != ds.findParent(adjNode)) {
                    count--;
                    ds.union(node, adjNode);
                }
            }
            ans.add(count);
        }
        return ans;
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
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