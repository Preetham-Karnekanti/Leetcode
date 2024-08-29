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
        boolean vis[] = new boolean[n];
        dfs(adj, 0, values, k, vis);
        return ans == 0 ? 1 : ans;
    }

    public long dfs(ArrayList<ArrayList<Integer>> adj, int node, int values[], int k, boolean vis[]) {
        long val = values[node];
        vis[node] = true;
        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                vis[nbr] = true;
                val += dfs(adj, nbr, values, k, vis);
            }
        }
        if (val % k == 0) {
            ans++;
            // val = 0;
        }
        return val;
    }
}