class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int components = 0;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (components == 1)
                    return false;
                dfs(adj, vis, i);
                components++;
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