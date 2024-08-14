class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int cycleLen = Integer.MAX_VALUE;
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).remove(v);
            adj.get(v).remove(u);
            cycleLen = Math.min(cycleLen, bfs(u, v, adj));
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return cycleLen == Integer.MAX_VALUE ? -1 : cycleLen + 1;
    }

    public int bfs(int src, int dest, ArrayList<HashSet<Integer>> adj) {
        int distance[] = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int distanceSoFar = cur[1];
            int node = cur[0];
            for (int ngh : adj.get(node)) {
                if (1 + distanceSoFar < distance[ngh]) {
                    distance[ngh] = 1 + distanceSoFar;
                    q.add(new int[] { ngh, distance[ngh] });
                }
            }
        }
        return distance[dest];
    }
}