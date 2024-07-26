class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int cost[][] = new int[n][n];
        for (int i[] : cost)
            Arrays.fill(i, (int) 1e9);
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            cost[u][v] = e[2];
            cost[v][u] = e[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        cost[i][j] = 0;
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        int minNode = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (cost[i][j] <= distanceThreshold)
                    count++;
            }
            if (minNode >= count) {
                minNode = count;
                node = i;
            }
        }
        return node;
    }
}