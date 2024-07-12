class Solution {
    public int removeStones(int[][] stones) {
        HashSet<Integer> stonesNode = new HashSet<>();
        int maxRow = 0, maxCol = 0;
        for (int e[] : stones) {
            maxRow = Math.max(maxRow, e[0]);
            maxCol = Math.max(maxCol, e[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        for (int e[] : stones) {
            int nodeRow = e[0];
            int nodeCol = e[1] + maxRow + 1;
            stonesNode.add(nodeRow);
            stonesNode.add(nodeCol);
            ds.unionBySize(nodeRow, nodeCol);
        }
        int count = 0;
        for (int key : stonesNode) {
            if (ds.findParent(key) == key)
                count++;
        }
        int n = stones.length;
        return n - count;
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
        if (pv == pu)
            return;
        if (size[pv] > size[pu]) {
            size[pv] += size[pu];
            parent[pu] = pv;
        } else {
            size[pu] += size[pv];
            parent[pv] = pu;
        }
    }
}