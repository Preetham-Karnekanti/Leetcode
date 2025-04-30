class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DisjointSet ds = new DisjointSet(n);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] - nums[i - 1] <= maxDiff)
                ds.union(i, i - 1);
        boolean ans[] = new boolean[queries.length];
        for(int i = 0;i<ans.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            int pu = ds.findParent(u);
            int pv = ds.findParent(v);
            ans[i] = pu == pv;
        }
        return ans;
    }
}

class DisjointSet {
    int size[];
    int parent[];

    DisjointSet(int n) {
        size = new int[n];
        parent = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++)
            parent[i] = i;
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
}