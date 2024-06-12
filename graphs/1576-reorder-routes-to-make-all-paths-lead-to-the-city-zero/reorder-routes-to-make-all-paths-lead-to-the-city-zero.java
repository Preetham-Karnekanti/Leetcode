class Solution {
    public int minReorder(int n, int[][] connections) {
        int count = 0;
        HashSet<String> hs = new HashSet<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int e[] : connections) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            hs.add(u + "->" + v);
        }
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int neighbour : graph.get(cur)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                    if (hs.contains(cur + "->" + neighbour))
                        count++;
                }
            }
        }
        return count;
    }
}