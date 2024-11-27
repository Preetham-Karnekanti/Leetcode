class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = i;
            int v = i + 1;
            adj.get(u).add(v);
        }
        int ans[] = new int[queries.length];
        int idx = 0;
        for (int q[] : queries) {
            int u = q[0];
            int v = q[1];
            adj.get(u).add(v);
            ans[idx++] = bfs(adj);
        }
        return ans;
    }

    public int bfs(ArrayList<ArrayList<Integer>> adj) {
        int distance[] = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        distance[0] = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int node = cur[0];
            int distanceSoFar = cur[1];
            for (int ngh : adj.get(node)) {
                if (distance[ngh] > 1 + distanceSoFar) {
                    distance[ngh] = 1 + distanceSoFar;
                    q.add(new int[] { ngh, distance[ngh] });
                }
            }
        }
        return distance[distance.length - 1];
    }
}