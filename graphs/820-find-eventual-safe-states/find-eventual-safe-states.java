class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer> al = new ArrayList<>();
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, pathVis);
            }
        }
        for (int i = 0; i < n; i++) {
            if (pathVis[i] == false)
                al.add(i);
        }
        return al;
    }

    public boolean dfs(int graph[][], int start, boolean vis[], boolean pathVis[]) {
        vis[start] = true;
        pathVis[start] = true;
        for (int ngh : graph[start]) {
            if (!vis[ngh]) {
                vis[ngh] = true;
                pathVis[ngh] = true;
                if (dfs(graph, ngh, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[ngh])
                return true;
        }
        pathVis[start] = false;
        return false;
    }
}