class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<List<Integer>>> graph = createGraph(n, redEdges, blueEdges);

        // int[] -> [node, color, level] : color -> 0 if Red and 1 if Blue
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 0 });
        queue.add(new int[] { 0, 1, 0 });

        boolean[][] visited = new boolean[2][n]; // 2D array for storing both the colors
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // BFS
        while (!queue.isEmpty()) {
            int[] rem = queue.remove();
            int node = rem[0], color = rem[1], level = rem[2];

            // if 'node' has been visited with the 'color' already then do nothing else
            // visit it
            if (visited[color][node])
                continue;
            visited[color][node] = true;

            if (ans[node] == -1)
                ans[node] = level;

            for (int neighbor : graph.get(node).get(color)) {
                int nextColor = color == 0 ? 1 : 0; // Pick the alternate color
                if (!visited[nextColor][neighbor]) { // Add neighbor if not visited
                    queue.add(new int[] { neighbor, nextColor, level + 1 });
                }
            }
        }

        return ans;
    }

    private List<List<List<Integer>>> createGraph(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<List<Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            graph.get(i).add(new ArrayList<>()); // for Red color (index-0)
            graph.get(i).add(new ArrayList<>()); // for Blue color (index-1)
        }

        for (int[] edge : redEdges) {
            graph.get(edge[0]).get(0).add(edge[1]); // Adding in Red(0) list
        }

        for (int[] edge : blueEdges) {
            graph.get(edge[0]).get(1).add(edge[1]); // Adding in Blue(1) list
        }

        return graph;
    }
}