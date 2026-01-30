class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int wt = cost[i];
            adj.get(u).add(new Pair(v, wt));
        }
        int distance[][] = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int[] temp = minDistance(i, adj);
            distance[i] = temp;
        }
        long sum = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (distance[s][t] == (int) 1e9)
                return -1;
            sum += distance[s][t];
        }
        return sum;
    }

    public int[] minDistance(int source, ArrayList<ArrayList<Pair>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { source, 0 });
        int distance[] = new int[26];
        Arrays.fill(distance, (int) 1e9);
        distance[source] = 0;
        while (!pq.isEmpty()) {
            int cur[] = pq.poll();
            int node = cur[0];
            int distanceSoFar = cur[1];
            for (Pair ngh : adj.get(node)) {
                int adjNode = ngh.node;
                int wt = ngh.cost;
                if (wt + distanceSoFar < distance[adjNode]) {
                    distance[adjNode] = wt + distanceSoFar;
                    pq.add(new int[] { adjNode, distance[adjNode] });
                }
            }
        }
        return distance;
    }
}

class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
        this.cost = cost;
        this.node = node;
    }
}