class Solution {
    boolean visited[];

    public int countCompleteComponents(int n, int[][] edges) {
        visited = new boolean[n];
        int count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && bfs(graph, i)) {
                count++;
            }
        }
        return count;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> graph, int start) {
        visited[start] = true;
        int edges = 0;
        int nodes = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            nodes++;
            ArrayList<Integer> neighbours = graph.get(cur);
            for (int next : neighbours) {
                edges++;
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        edges /= 2;
        return edges == (nodes) * (nodes - 1) / 2;
    }
}