class Solution {
    long fuel;

    public long minimumFuelCost(int[][] roads, int seats) {
        fuel = 0;
        int n = roads.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int e[] : roads) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        dfs(0, adj, n, seats, new boolean[n + 1]);
        return fuel;
    }

    public int dfs(int city, List<List<Integer>> adj, int n, int seats, boolean[] vis) {
        if (city > n || vis[city])
            return 0;
        int count = 0;
        vis[city] = true;
        for (int ngh : adj.get(city)) {
            count += dfs(ngh, adj, n, seats, vis);
        }
        count++;
        if (city != 0)
            fuel += count % seats == 0 ? count / seats : count / seats + 1;
        return count;
    }
}