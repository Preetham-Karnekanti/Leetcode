class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int timeSoFar = 0;
        boolean visited[] = new boolean[n + 1];
        visited[1] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 1, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.time == t && p.node == target) {
                return p.probability;
            }
            double children = adj.get(p.node).size();
            if (p.node != 1)
                children--;
            if (children == 0) {
                if (p.node == target && p.time <= t)
                    return p.probability;
                continue;
            }
            for (int child : adj.get(p.node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    int time = p.time + 1;
                    double probability = p.probability * (1 / children);
                    q.add(new Pair(child, probability, time));
                }
            }
        }
        return 0;
    }
}

class Pair {
    int node;
    double probability;
    int time;

    Pair(int cur, double probability, int time) {
        this.node = cur;
        this.probability = probability;
        this.time = time;
    }
}
