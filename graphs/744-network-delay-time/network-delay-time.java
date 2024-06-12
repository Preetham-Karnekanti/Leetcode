class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int distance[] = new int[n + 1];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : times) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Pair(v, wt));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int curDistance = cur[0];
            int curNode = cur[1];
            for (Pair p : adj.get(curNode)) {
                int wt = p.wt;
                int adjNode = p.node;
                if (wt + curDistance < distance[adjNode]) {
                    distance[adjNode] = wt + curDistance;
                    pq.add(new int[] { distance[adjNode], adjNode });
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}

class Pair {
    int node;
    int wt;

    Pair(int n, int w) {
        node = n;
        wt = w;
    }
}