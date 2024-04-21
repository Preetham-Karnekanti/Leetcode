class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(graph, source, destination, new boolean[n]);
    }

    public boolean dfs(List<List<Integer>> graph, int source, int destination, boolean visited[]) {
        if (source == destination)
            return true;
        visited[source] = true;
        for (int neighbour : graph.get(source)) {
            if (visited[neighbour] == false) {
                if (dfs(graph, neighbour, destination, visited))
                    return true;
            }
        }
        return false;
    }
}