class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int u = i;
            int v = manager[i];
            if (v != -1)
                adj.get(v).add(u);
        }

        int distance[] = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[headID] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { headID, 0 });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int node = cur[0];
            int timeSoFar = cur[1];
            for (int adjNode : adj.get(node)) {
                int timeToInform = informTime[node];
                if (timeToInform + timeSoFar < distance[adjNode]) {
                    distance[adjNode] = timeToInform + timeSoFar;
                    q.add(new int[] { adjNode, distance[adjNode] });
                }
            }
        }
        int max = 0;
        for (int i : distance)
            max = Math.max(max, i);
        return max;
    }
}
