class Solution {
    public int minTime(int n, int[][] edges, int k) {
        int low = 0;
        int high = 0;
        for (int e[] : edges)
            high = Math.max(high, e[2]);
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(n, edges, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int n, int[][] edges, int minComponents, int curTime) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int time = e[2];
            if (time <= curTime) {
                continue;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis);
                count++;
            }
        }
        return count >= minComponents;
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean vis[]) {
        vis[node] = true;
        for (int ngh : graph.get(node)) {
            if (!vis[ngh]) {
                dfs(graph, ngh, vis);
            }
        }
    }
}