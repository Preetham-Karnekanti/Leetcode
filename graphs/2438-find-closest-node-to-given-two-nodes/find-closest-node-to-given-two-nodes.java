class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int dist1[] = new int[n];
        int dist2[] = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = dist2[node2] = 0;
        bfs(edges, dist1, node1);
        bfs(edges, dist2, node2);
        int minDistance = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            int max = Math.max(dist1[i], dist2[i]);
            if (minDistance > max) {
                minDistance = max;
                node = i;
            }
        }
        return node;
    }

    public void bfs(int[] edges, int[] distance, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[] { 0, start });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int distanceSoFar = cur[0];
            int node = cur[1];
            if (edges[node] != -1 && 1 + distanceSoFar < distance[edges[node]]) {
                distance[edges[node]] = 1 + distanceSoFar;
                pq.add(new int[] { distance[edges[node]], edges[node] });
            }
        }
    }
}