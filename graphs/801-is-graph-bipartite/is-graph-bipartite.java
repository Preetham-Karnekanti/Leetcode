class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++)
                adj.get(i).add(graph[i][j]);
        }
        int colors[] = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1)
                if (bfs(adj, i, colors) == false)
                    return false;
        }
        return true;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int ngh : adj.get(cur)) {
                if (color[ngh] == -1) {
                    color[ngh] = 1 - color[cur];
                    q.add(ngh);
                } else if (color[ngh] == color[cur])
                    return false;
            }
        }
        return true;
    }
}