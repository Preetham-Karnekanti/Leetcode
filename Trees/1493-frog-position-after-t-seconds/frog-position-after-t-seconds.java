class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            al.get(v).add(u);
            al.get(u).add(v);
        }
        Queue<Pair> q = new LinkedList<>();
        boolean visited[] = new boolean[n + 1];
        q.add(new Pair(1, 0, 1));
        visited[1] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.time == t && p.node == target)
                return p.probability;
            int children = al.get(p.node).size();
            if (p.node != 1)
                children--;
            if (children == 0) {
                if (target == p.node && p.time <= t)
                    return p.probability;
            }
            for (int child : al.get(p.node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    int time = p.time + 1;
                    double probability = p.probability / children;
                    q.add(new Pair(child, time, probability));
                }
            }
        }
        return 0;
    }
}

class Pair {
    int node, time;
    double probability;

    Pair(int node, int time, double probability) {
        this.probability = probability;
        this.node = node;
        this.time = time;
    }

}