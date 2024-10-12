class Solution {
    int dp[][];

    public int maximumCost(int n, int[][] highways, int k) {
        dp = new int[n][1 << n];
        for (int i[] : dp)
            Arrays.fill(i, Integer.MIN_VALUE);
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : highways) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            int temp = helper(graph, i, (1 << i), k);
            res = Math.max(res, temp);
        }
        return res;
    }

    public int helper(ArrayList<ArrayList<Pair>> graph, int curNode, int mask, int k) {
        if (k == 0)
            return 0;
        if (dp[curNode][mask] != Integer.MIN_VALUE)
            return dp[curNode][mask];
        int max = -(int) 1e5;
        for (var nei : graph.get(curNode)) {
            if (checkBit(mask, nei.node) == 0) {
                int newMask = mask | (1 << nei.node);
                max = Math.max(max, nei.wt + helper(graph, nei.node, newMask, k - 1));
            }
        }
        return dp[curNode][mask] = max;
    }

    public int checkBit(int num, int i) {
        return (num >> i) & 1;
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
