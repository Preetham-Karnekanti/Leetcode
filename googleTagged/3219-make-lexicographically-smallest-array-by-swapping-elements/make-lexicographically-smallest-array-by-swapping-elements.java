class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(pairs, (a, b) -> a.value - b.value);
        for (int i = 1; i < n; i++) {
            if (pairs[i].value - pairs[i - 1].value <= limit) {
                ds.union(pairs[i - 1].idx, pairs[i].idx);
            }
        }
        HashMap<Integer, ArrayDeque<Integer>> hm = new HashMap<>();
        for (Pair p : pairs) {
            int parent = ds.findParent(p.idx);
            if (!hm.containsKey(parent)) {
                hm.put(parent, new ArrayDeque<>());
            }
            hm.get(parent).offer(p.value);
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int parent = ds.findParent(i);
            ans[i] = hm.get(parent).poll();
        }
        return ans;
    }
}

class Pair {
    int idx, value;

    Pair(int idx, int v) {
        this.idx = idx;
        this.value = v;
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
        if (u == parent[u])
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
}