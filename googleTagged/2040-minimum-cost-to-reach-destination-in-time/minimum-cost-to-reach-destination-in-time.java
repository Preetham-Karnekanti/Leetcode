class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        int n = passingFees.length;
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Edge(v, wt));
            adj.get(v).add(new Edge(u, wt));
        }
        int time[] = new int[n];
        Arrays.fill(time, (int) 1e9);
        Queue<Cell> pq = new PriorityQueue<>((a, b) -> a.cost == b.cost ? a.time - b.time : a.cost - b.cost);
        pq.add(new Cell(0, 0, passingFees[0]));
        time[0] = 0;
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int node = cur.node;
            int timeSoFar = cur.time;
            int cost = cur.cost;
            if (node == n - 1)
                return cost;
            for (Edge ngh : adj.get(node)) {
                int adjNode = ngh.node;
                int wt = ngh.wt;
                if (wt + timeSoFar > maxTime)
                    continue;
                if (wt + timeSoFar < time[adjNode]) {
                    pq.add(new Cell(adjNode, wt + timeSoFar, cost + passingFees[adjNode]));
                    time[adjNode] = wt + timeSoFar;
                }
            }
        }
        return -1;
    }
}

class Cell {
    int time;
    int cost;
    int node;

    Cell(int n, int t, int c) {
        time = t;
        cost = c;
        node = n;
    }
}

class Edge {
    int node;
    int wt;

    Edge(int node, int wt) {
        this.wt = wt;
        this.node = node;
    }
}