class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        int componentCost[] = new int[n];
        Arrays.fill(componentCost, Integer.MAX_VALUE);
        for (int e[] : edges) {
            ds.union(e[0], e[1], e[2]);
        }

        for (int i[] : edges) {
            int root = ds.findParent(i[0]);
            componentCost[root] &= i[2];
        }

        int ans[] = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0];
            int v = query[i][1];
            if (ds.findParent(u) != ds.findParent(v))
                ans[i] = -1;
            else {
                int parent = ds.findParent(u);
                ans[i] = componentCost[parent];
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
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    void union(int u, int v, int wt) {
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

    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
}