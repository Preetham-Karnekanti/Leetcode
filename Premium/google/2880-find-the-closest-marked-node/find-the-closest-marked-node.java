class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);
            graph.get(u).add(new Pair(v, wt));
        }
        pq.add(new int[] { s, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int distanceSoFar = cur[1];
            for (Pair ngh : graph.get(node)) {
                int adjNode = ngh.node;
                int wt = ngh.wt;
                if (distance[adjNode] > distanceSoFar + wt) {
                    distance[adjNode] = distanceSoFar + wt;
                    pq.add(new int[] { adjNode, distanceSoFar + wt });
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

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}