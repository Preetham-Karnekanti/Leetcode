class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        if (adj.get(destination).size() != 0)
            return false;
        return dfs(adj, source, destination, new int[n]);
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int current, int destination, int[] state) {
        // state: 0 = unvisited, 1 = visiting, 2 = visited
        if (state[current] != 0) return state[current] == 2;
        if (adj.get(current).size() == 0) return current == destination;
        
        state[current] = 1; // mark as visiting
        for (int ngh : adj.get(current)) {
            if (!dfs(adj, ngh, destination, state))
                return false;
        }
        state[current] = 2; // mark as fully visited
        return true;
    }
}
