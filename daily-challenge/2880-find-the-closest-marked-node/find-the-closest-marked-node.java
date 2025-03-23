class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);
            adj.get(u).add(new Pair(v, wt));
        }
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(s, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curNode = cur.node;
            int distanceSoFar = cur.wt;
            for (Pair ngh : adj.get(curNode)) {
                int adjNode = ngh.node;
                int wt = ngh.wt;
                if (distance[adjNode] > distanceSoFar + wt) {
                    distance[adjNode] = distanceSoFar + wt;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : marked) {
            ans = Math.min(ans, distance[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

class Pair {
    int node;
    int wt;

    Pair(int n, int d) {
        this.node = n;
        this.wt = d;
    }
}