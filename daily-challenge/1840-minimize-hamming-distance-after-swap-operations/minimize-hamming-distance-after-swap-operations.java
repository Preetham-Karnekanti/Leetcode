class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind u = new UnionFind(n);

        for (int p[] : allowedSwaps) {
            u.union(p[0], p[1]);
        }

        Map<Integer, Map<Integer, Integer>> sets = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = u.findParent(i);
            sets.putIfAbsent(p, new HashMap<>());
            Map<Integer, Integer> cnt = sets.get(p);
            cnt.put(source[i], cnt.getOrDefault(source[i], 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int p = u.findParent(i);
            Map<Integer, Integer> cnt = sets.get(p);
            if (cnt.getOrDefault(target[i], 0) > 0) {
                cnt.put(target[i], cnt.get(target[i]) - 1);
            } else {
                ans++;
            }
        }
        return ans;
    }
}

class UnionFind {
    int n;
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

    void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) {
            return;
        }
        if (size[pu] > size[v]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }

    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
}