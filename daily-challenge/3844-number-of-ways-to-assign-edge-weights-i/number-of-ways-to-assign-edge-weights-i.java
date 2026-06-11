class Solution {

    private static final int MOD = 1_000_000_007;

    private int qpow(int x, int y) {
        if (y == 0) return 1;

        long half = qpow(x, y / 2);
        long result = (half * half) % MOD;

        if ((y & 1) == 1) {
            result = (result * x) % MOD;
        }

        return (int) result;
    }

    private int dfs(List<List<Integer>> g, int x, int f) {
        int maxDep = 0;

        for (int y : g.get(x)) {
            if (y == f) continue;
            maxDep = Math.max(maxDep, dfs(g, y, x) + 1);
        }

        return maxDep;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            g.get(u).add(v);
            g.get(v).add(u);
        }

        int maxDep = dfs(g, 1, 0);

        return qpow(2, maxDep - 1);
    }
}