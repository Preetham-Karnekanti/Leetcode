class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double weight = succProb[i];
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double probabilities[] = new double[n];
        probabilities[start_node] = 1.0;
        pq.add(new Pair(start_node, 1.0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (Pair ngh : adj.get(cur.node)) {
                if (cur.prob * ngh.prob > probabilities[ngh.node]) {
                    probabilities[ngh.node] = cur.prob * ngh.prob;
                    pq.add(new Pair(ngh.node, cur.prob * ngh.prob));
                }
            }
        }
        return probabilities[end_node];
    }
}

class Pair {
    int node;
    double prob;

    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}