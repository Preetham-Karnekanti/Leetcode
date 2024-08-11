class Solution {
    public int earliestAcq(int[][] logs, int n) {
        DisjointSet ds = new DisjointSet(n);
        Arrays.sort(logs, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        HashSet<Integer> hs = new HashSet<>();
        for (int l[] : logs) {
            int time = l[0];
            int u = l[1];
            int v = l[2];

            if (ds.findParent(u) != ds.findParent(v)) {
                ds.union(u, v);
                hs.add(u);
                hs.add(v);
            }
            if (hs.size() == n && ds.hasSameParent())
                return time;
        }
        return -1;
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

    public boolean hasSameParent() {
        int p = findParent(0);
        for (int i = 0; i < parent.length; i++) {
            if (findParent(i) != p)
                return false;
        }
        return true;
    }
}