class Solution {
    public long countPairs(int n, int[][] edges) {
        long connectedPairs = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.parent(i) == i) {
                list.add(uf.rank[i] + 0L);
            }
        }

        // --------- Math problem here -------------
        long total = n * (n - 1L) / 2;
        for (long i : list) {
            connectedPairs += i * (i - 1) / 2;
        }
        return total - connectedPairs;
    }
}

class UnionFind {
    int n;
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public int parent(int x) {
        if (this.parent[x] != x) {
            this.parent[x] = parent(this.parent[x]);
        }
        return this.parent[x];
    }

    public void union(int x, int y) {
        int parentX = parent(x);
        int parentY = parent(y);
        if (parentX == parentY) {
            return;
        }
        if (rank[parentX] > rank[parentY]) {
            rank[parentX] += rank[parentY];
            parent[parentY] = parentX;
        } else {
            rank[parentY] += rank[parentX];
            parent[parentX] = parentY;
        }
    }
}