class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int e[] : roads) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            g.get(u).add(new Pair(v, w));
            g.get(v).add(new Pair(u, w));
        }
        int ans = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Pair p : g.get(node)) {
                ans = Math.min(ans, p.weight);

                if (!vis[p.node]) {
                    vis[p.node] = true;
                    q.offer(p.node);
                }
            }
        }
        return ans;
    }
}

class Pair {
    int node;
    int weight;

    Pair(int n, int w) {
        node = n;
        weight = w;
    }
}