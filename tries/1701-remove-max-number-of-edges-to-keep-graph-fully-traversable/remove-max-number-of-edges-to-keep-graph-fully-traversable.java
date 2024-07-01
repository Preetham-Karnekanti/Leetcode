class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        DisjointSet ads = new DisjointSet(n + 1);
        DisjointSet bds = new DisjointSet(n + 1);
        int a = 0, b = 0, extra = 0;
        for (int e[] : edges) {
            int u = e[1];
            int v = e[2];
            int type = e[0];
            if (type == 1) {
                if (ads.findParent(u) != ads.findParent(v)) {
                    ads.unionBySize(u, v);
                    a++;
                } else
                    extra++;
            } else if (type == 2) {
                if (bds.findParent(u) != bds.findParent(v)) {
                    bds.unionBySize(u, v);
                    b++;
                } else
                    extra++;
            } else {
                if (ads.findParent(u) != ads.findParent(v)) {
                    ads.unionBySize(u, v);
                    bds.unionBySize(u, v);
                    a++;
                    b++;
                } else
                    extra++;
            }
        }
        return (a == n - 1 && b == n - 1) ? extra : -1;
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
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}