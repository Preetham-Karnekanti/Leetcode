class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        DisjointSet ds = new DisjointSet(n + 10);
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int p[] : pipes) {
            int u = p[0] - 1;
            int v = p[1] - 1;
            int cost = p[2];
            edges.add(new ArrayList<>(Arrays.asList(u, v, cost)));
        }
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = n + 2;
            int cost = wells[i];
            edges.add(new ArrayList<>(Arrays.asList(u, v, cost)));
        }
        Collections.sort(edges, (a, b) -> a.get(2) - b.get(2));
        int minCost = 0;
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int cost = edge.get(2);
            if (ds.findParent(u) != ds.findParent(v)) {
                minCost += cost;
                ds.unionBySize(u, v);
            }
        }
        return minCost;
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

    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    void unionBySize(int u, int v) {
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