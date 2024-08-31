class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int idx = 0;
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(new Pair(v, succProb[idx]));
            adj.get(v).add(new Pair(u, succProb[idx]));
            idx++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double probabilities[] = new double[n];
        probabilities[start_node] = 1;
        pq.add(new Pair(start_node, 1.0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            double prob = cur.prob;

            for (Pair ngh : adj.get(node)) {
                int adjNode = ngh.node;
                double nextProb = ngh.prob;
                if (prob * nextProb > probabilities[adjNode]) {
                    probabilities[adjNode] = prob * nextProb;
                    pq.add(new Pair(adjNode, probabilities[adjNode]));
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