class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : flights) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
        }
        Queue<int[]> q = new LinkedList<>();
        int distance[] = new int[n];
        Arrays.fill(distance, (int) 1e9);
        q.add(new int[] { 0, 0, src });
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int distanceSoFar = cur[0];
            int stops = cur[1];
            int node = cur[2];
            if (stops > k)
                continue;
            for (Pair ngh : adj.get(node)) {
                int adjNode = ngh.node;
                int weight = ngh.weight;
                if (weight + distanceSoFar < distance[adjNode] && stops <= k) {
                    distance[adjNode] = weight + distanceSoFar;
                    q.add(new int[] { weight + distanceSoFar, stops + 1, adjNode });
                }
            }
        }
        return distance[dst] == (int) 1e9 ? -1 : distance[dst];
    }
}

class Pair {
    int node;
    int weight;

    Pair(int n, int d) {
        node = n;
        weight = d;
    }
}