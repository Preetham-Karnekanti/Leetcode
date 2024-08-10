class Solution {
    public int countComponents(int n, int[][] edges) {
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
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                count++;
                dfs(adj, vis, i);
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int node) {
        vis[node] = true;
        for (int ngh : adj.get(node)) {
            if (!vis[ngh])
                dfs(adj, vis, ngh);
        }
    }
}