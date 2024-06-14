class Graph {
    ArrayList<ArrayList<Pair>> adj;
    int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            addEdge(e);
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];
        adj.get(u).add(new Pair(v, wt));
    }

    public int shortestPath(int node1, int node2) {
        return bfs(node1, node2);
    }

    public int bfs(int src, int dest) {
        int dis[] = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, src });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int node = cur[1];
            int distance = cur[0];
            for (Pair ngh : adj.get(node)) {
                int adjNode = ngh.node;
                int wt = ngh.wt;
                if (dis[adjNode] > wt + distance) {
                    dis[adjNode] = wt + distance;
                    pq.add(new int[] { wt + distance, adjNode });
                }
            }
        }
        return dis[dest] == (int) 1e9 ? -1 : dis[dest];
    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */