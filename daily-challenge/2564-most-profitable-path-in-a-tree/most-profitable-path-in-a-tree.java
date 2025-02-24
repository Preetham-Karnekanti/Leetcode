class Solution {
    ArrayList<ArrayList<Integer>> tree;
    boolean vis[];
    HashMap<Integer, Integer> arrivalTimeOfBob;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        arrivalTimeOfBob = new HashMap<>();
        tree = new ArrayList<>();
        int n = amount.length;
        vis = new boolean[n];
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        bobPath(bob, 0);
        Arrays.fill(vis, false);
        int maxIncome = Integer.MIN_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });
        vis[0] = true;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int node = cur[0];
            int time = cur[1];
            int income = cur[2];

            if (!arrivalTimeOfBob.containsKey(node) || time < arrivalTimeOfBob.get(node)) {
                income += amount[node];
            } else if (time == arrivalTimeOfBob.get(node)) {
                income += amount[node] / 2;
            }

            if (tree.get(node).size() == 1 && node != 0) {
                maxIncome = Math.max(maxIncome, income);
            }
            for (int adj : tree.get(node)) {
                if (!vis[adj]) {
                    q.add(new int[] { adj, time + 1, income });
                    vis[adj] = true;
                }
            }

        }
        return maxIncome;
    }

    private boolean bobPath(int src, int time) {
        arrivalTimeOfBob.put(src, time);
        vis[src] = true;
        if (src == 0)
            return true;
        for (int adj : tree.get(src)) {
            if (!vis[adj]) {
                if (bobPath(adj, time + 1))
                    return true;
            }
        }
        arrivalTimeOfBob.remove(src);
        vis[src] = false;
        return false;
    }
}