class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            n = Math.max(n, u);
            n = Math.max(n, v);
        }
        int ans[] = new int[2];
        DisjointSet ds = new DisjointSet(n + 1);
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            if (ds.findParent(u) != ds.findParent(v)) {
                ds.unionBySize(u, v);
            } else {
                ans[0] = u;
                ans[1] = v;
            }
        }
        return ans;
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