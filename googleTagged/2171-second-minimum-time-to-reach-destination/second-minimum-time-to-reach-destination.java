class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int secondMinDistance = dijkstras(adj);
        return getUpdatedTime(secondMinDistance, change, time);
    }

    public int dijkstras(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int distance1[] = new int[n];
        int distance2[] = new int[n];
        Arrays.fill(distance1, (int) 1e9);
        Arrays.fill(distance2, (int) 1e9);
        distance1[1] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 1, 0 });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int node = cur[0];
            int distanceSoFar = cur[1];
            for (int ngh : adj.get(node)) {
                int newDistance = 1 + distanceSoFar;
                if (newDistance < distance1[ngh]) {
                    distance2[ngh] = distance1[ngh];
                    distance1[ngh] = newDistance;
                    pq.add(new int[] { ngh, newDistance });
                } else if (newDistance > distance1[ngh] && newDistance < distance2[ngh]) {
                    distance2[ngh] = newDistance;
                    pq.add(new int[] { ngh, newDistance });
                }
            }
        }
        return distance2[n - 1];
    }

    int getUpdatedTime(int secondMinDist, int change, int time) {
        int totalTime = 0;
        for (int i = 0; i < secondMinDist; i++) {
            if ((totalTime / change) % 2 == 1) {
                totalTime += change - (totalTime % change);
            }
            totalTime += time;
        }

        return totalTime;
    }
}