class Solution {
    int timer;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        timer = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> e : connections) {
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int tin[] = new int[n];
        int low[] = new int[n];
        dfs(0, -1, adj, new boolean[n], tin, low, bridges);
        return bridges;
    }

    public void dfs(int node, int parent, List<List<Integer>> adj, boolean vis[], int[] tin, int low[],
            List<List<Integer>> bridges) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;
            if (!vis[adjNode]) {
                dfs(adjNode, node, adj, vis, tin, low, bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > tin[node]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(adjNode);
                    bridges.add(temp);
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }
}