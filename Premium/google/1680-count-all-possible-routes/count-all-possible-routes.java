class Solution {
    int m = (int) 1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int dp[][] = new int[locations.length][fuel + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(locations, finish, fuel, start, dp);
    }

    public int helper(int[] locations, int dest, int fuel, int curCity, int[][] dp) {
        if (fuel < 0)
            return 0;
        if (dp[curCity][fuel] != -1)
            return dp[curCity][fuel];
        int ways = 0;
        if (curCity == dest)
            ways = 1;
        for (int i = 0; i < locations.length; i++) {
            if (i != curCity)
                ways = (ways + helper(locations, dest, fuel - Math.abs(locations[curCity] - locations[i]), i, dp)) % m;
        }
        return dp[curCity][fuel] = ways;
    }
}