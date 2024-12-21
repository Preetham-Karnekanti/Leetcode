class Solution {
    int ans = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ans = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(adj, 0, new boolean[n], k, values);
        return ans == 0 ? 1 : ans;
    }

    public long dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, int k, int[] values) {
        vis[node] = true;
        long val = values[node];

        for (int ngh : adj.get(node)) {
            if (!vis[ngh]) {
                val += dfs(adj, ngh, vis, k, values);
            }
        }
        if (val % k == 0) {
            ans++;
            val = 0;
        }
        return val;
    }
}