class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : paths) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n + 1];
        int ans[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(adj, vis, ans, i);
            }
        }
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ans[i + 1];
        }
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int ans[], int node) {
        vis[node] = true;
        int colors[] = new int[5];
        for(int ngh : adj.get(node)){
            colors[ans[ngh]] = 1;
        }
        for (int i = 1; i <= 4; i++) {
            if (colors[i] == 0) {
                ans[node] = i;
                break;
            }
        }
        for (int ngh : adj.get(node)) {
            if (!vis[ngh]) {
                dfs(adj, vis, ans, ngh);
            }
        }
    }
}