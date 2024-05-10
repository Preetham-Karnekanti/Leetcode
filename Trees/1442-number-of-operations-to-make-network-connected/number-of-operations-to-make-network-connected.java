class Solution {
    public int makeConnected(int n, int[][] connections) {
        boolean visited[] = new boolean[n];
        int edges = connections.length;
        if (edges < n - 1)
            return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : connections) {
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, adj);
                count++;
            }
        }
        return count - 1;
    }

    public void bfs(int start, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int ngh : adj.get(cur)) {
                if (!visited[ngh]) {
                    q.add(ngh);
                    visited[ngh] = true;
                }
            }
        }
    }
}