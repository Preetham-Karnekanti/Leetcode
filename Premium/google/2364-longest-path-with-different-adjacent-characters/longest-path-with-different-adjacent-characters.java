class Solution {
    int ans = 0;
    int distance[];

    public int longestPath(int[] parent, String s) {
        ans = 1;
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int n = s.length();
        distance = new int[n];
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        for (int i = 1; i < parent.length; i++) {
            tree.get(parent[i]).add(i);
        }
        dfs(tree, 0, s);
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, String s) {
        distance[node] = 1;
        int max = 0;
        for (int child : adj.get(node)) {
            dfs(adj, child, s);
            if (s.charAt(node) != s.charAt(child)) {
                ans = Math.max(ans, distance[node] + distance[child]);
                distance[node] = Math.max(distance[node], 1 + distance[child]);
            }
        }
    }
}