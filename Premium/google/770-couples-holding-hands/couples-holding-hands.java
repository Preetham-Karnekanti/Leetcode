class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length, count = 0;
        DisjointSet ds = new DisjointSet(n / 2);
        for (int i = 0; i < n; i += 2) {
            if (!isCouple(row[i], row[i + 1])) {
                if (ds.findParent(row[i] / 2) != ds.findParent(row[i + 1] / 2)) {
                    count++;
                    ds.union(row[i] / 2, row[i + 1] / 2);
                }
            }
        }
        return count;
    }

    private boolean isCouple(int i, int j) {
        return (Math.min(i, j) & 1) == 0 && Math.abs(i - j) == 1;
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
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}