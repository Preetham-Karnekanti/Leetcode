class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int cost = 0;
        DisjointSet ds = new DisjointSet(n + 1);
        for (int e[] : connections) {
            int u = e[0];
            int v = e[1];

            if (ds.findParent(u) != ds.findParent(v)) {
                cost += e[2];
                ds.union(u, v);
            }
        }
        int parent = ds.findParent(1);
        for (int i = 1; i <= n; i++)
            if (ds.findParent(i) != parent)
                return -1;
        return cost;
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

    public int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
}