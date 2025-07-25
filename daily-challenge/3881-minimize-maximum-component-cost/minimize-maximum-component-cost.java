class Solution {
    public int minCost(int n, int[][] edges, int k) {
        int low = 0;
        int high = 0;
        for (int e[] : edges) {
            int w = e[2];
            high = Math.max(high, w);
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormKComponents(edges, mid, k, n)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public boolean canFormKComponents(int edges[][], int mid, int k, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if (w <= mid) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                if (count > k)
                    return false;
                dfs(adj, vis, i);
            }
        }
        return true;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int node) {
        vis[node] = true;
        for (int ngh : adj.get(node)) {
            if (!vis[ngh]) {
                dfs(adj, vis, ngh);
            }
        }
    }
}

class DisjointSet {
    int size[], parent[];

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