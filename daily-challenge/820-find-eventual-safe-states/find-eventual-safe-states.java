class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = safe
        List<Integer> safeNodes = new ArrayList<>();
        
        // Perform DFS for each node
        for (int i = 0; i < n; i++) {
            if (dfs(graph, state, i)) {
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    
    private boolean dfs(int[][] graph, int[] state, int node) {
        if (state[node] != 0) {
            // Return true if the node is safe, false otherwise
            return state[node] == 2;
        }
        
        state[node] = 1; // Mark as visiting
        
        for (int neighbor : graph[node]) {
            // If a neighbor is not safe or part of a cycle, mark this node unsafe
            if (!dfs(graph, state, neighbor)) {
                return false;
            }
        }
        
        state[node] = 2; // Mark as safe
        return true;
    }
}
