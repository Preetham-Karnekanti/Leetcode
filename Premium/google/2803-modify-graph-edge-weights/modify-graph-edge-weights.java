class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int e[] : edges) {
            if (e[2] == -1)
                continue;
            int u = e[0];
            int v = e[1];
            adj.get(u).add(new Pair(v, e[2]));
            adj.get(v).add(new Pair(u, e[2]));
        }

        int currentShortestDistance = dijkstras(adj, source, destination);
        boolean isMatched = currentShortestDistance == target;
        if (currentShortestDistance < target)
            return new int[][] {};

        for (int e[] : edges) {
            if (e[2] != -1)
                continue;
            int u = e[0];
            int v = e[1];
            e[2] = isMatched ? (int) 2e9 : 1;
            adj.get(u).add(new Pair(v, e[2]));
            adj.get(v).add(new Pair(u, e[2]));

            if (isMatched == false) {
                int newDistance = dijkstras(adj, source, destination);

                if (newDistance <= target) {
                    isMatched = true;
                    e[2] += target - newDistance;
                }
            }
        }
        return isMatched ? edges : new int[][]{};
    }

    public int dijkstras(ArrayList<ArrayList<Pair>> adj, int source, int destination) {
        int distance[] = new int[adj.size()];
        Arrays.fill(distance, (int) 2e9);
        distance[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { source, 0 });
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int node = cur[0];
            int distanceSoFar = cur[1];

            for (Pair ngh : adj.get(node)) {
                int wt = ngh.wt;
                int adjNode = ngh.node;
                if (wt + distanceSoFar < distance[adjNode]) {
                    distance[adjNode] = wt + distanceSoFar;
                    pq.add(new int[] { adjNode, wt + distanceSoFar });
                }
            }
        }
        return distance[destination];
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
