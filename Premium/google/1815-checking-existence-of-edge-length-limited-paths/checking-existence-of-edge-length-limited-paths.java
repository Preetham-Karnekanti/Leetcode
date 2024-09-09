class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int q = queries.length;
        boolean answer[] = new boolean[q];
        UnionFind uf = new UnionFind(n);
        int queriesWithIndex[][] = new int[q][4];
        for (int i = 0; i < q; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        Arrays.sort(queriesWithIndex, (a, b) -> a[2] - b[2]);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int edgeIndex = 0;
        for (int i = 0; i < q; i++) {
            int limit = queriesWithIndex[i][2];
            int idx = queriesWithIndex[i][3];
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                int u = edgeList[edgeIndex][0];
                int v = edgeList[edgeIndex++][1];
                uf.union(u, v);
            }
            int u = queriesWithIndex[i][0];
            int v = queriesWithIndex[i][1];
            answer[idx] = uf.findParent(u) == uf.findParent(v);
        }
        return answer;
    }
}

class UnionFind {
    int parent[];
    int size[];

    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
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