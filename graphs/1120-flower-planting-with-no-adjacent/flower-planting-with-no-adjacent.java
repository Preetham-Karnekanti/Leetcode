class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : paths) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                bfs(i, adj, ans);
            }
        }
        return ans;
    }

    public void bfs(int node, ArrayList<ArrayList<Integer>> adj, int ans[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        ans[node] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int color = ans[cur];
            for (int ngh : adj.get(cur)) {
                if (ans[ngh] == 0 || ans[ngh] == ans[cur]) {
                    int nextColor = color == 4 ? 1 : color + 1;
                    ans[ngh] = nextColor;
                    q.add(ngh);
                }
            }
        }
    }
}