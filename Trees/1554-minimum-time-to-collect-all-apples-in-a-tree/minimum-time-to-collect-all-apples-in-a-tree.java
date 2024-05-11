class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(adj, vis, 0, hasApple);
    }

    public int dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int idx, List<Boolean> hasApple) {
        int result = 0;
        vis[idx] = true;
        for (int ngh : adj.get(idx)) {
            if (!vis[ngh])
                result += dfs(adj, vis, ngh, hasApple);
        }
        if (idx == 0)
            return result;
        if (result > 0 || hasApple.get(idx))
            result += 2;
        return result;
    }
}