class Tuple {
    int distance;
    int stops;
    int node;

    Tuple(int distance, int stops, int node) {
        this.distance = distance;
        this.stops = stops;
        this.node = node;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = buildGraph(flights, n);
        Queue<Tuple> q = new LinkedList<>();
        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        q.add(new Tuple(0, 0, src));
        while (!q.isEmpty()) {
            Tuple cur = q.poll();
            int stops = cur.stops;
            int node = cur.node;
            int distance = cur.distance;
            if (stops > k)
                continue;
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int weight = p.wt;
                if (weight + distance < dist[adjNode] && stops <= k) {
                    dist[adjNode] = weight + distance;
                    q.add(new Tuple(weight + distance, stops + 1, adjNode));
                }
            }
        }
        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
    }

    public ArrayList<ArrayList<Pair>> buildGraph(int[][] flights, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : flights) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
        }
        return adj;
    }
}

class Pair {
    int wt;
    int node;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}
