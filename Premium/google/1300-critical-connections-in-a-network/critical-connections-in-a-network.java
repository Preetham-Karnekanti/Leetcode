class Solution {
    int timer = 0;
    int tin[];
    int low[];
    boolean vis[];

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        low = new int[n];
        tin = new int[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (List<Integer> con : connections) {
            int u = con.get(0);
            int v = con.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(graph, answer, 0, -1);
        return answer;
    }

    public void dfs(List<List<Integer>> graph, List<List<Integer>> answer, int node, int parent) {
        tin[node] = timer;
        low[node] = timer;
        timer++;
        vis[node] = true;
        for (int ngh : graph.get(node)) {
            if (ngh == parent)
                continue;
            if (!vis[ngh]) {
                dfs(graph, answer, ngh, node);
                low[node] = Math.min(low[node], low[ngh]);
                if (low[ngh] > tin[node]) {
                    answer.add(new ArrayList<>(Arrays.asList(node, ngh)));
                }
            } else {
                low[node] = Math.min(low[node], low[ngh]);
            }
        }
    }
}