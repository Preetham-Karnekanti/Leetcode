class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis);
                count++;
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[]) {
        vis[src] = true;
        for (int ngh : adj.get(src)) {
            if (!vis[ngh])
                dfs(adj, ngh, vis);
        }
    }
}