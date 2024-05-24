class Solution {
    int dp[];

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[366];
        Arrays.fill(dp, -1);
        HashSet<Integer> hs = new HashSet<>();
        for (int i : days)
            hs.add(i);
        return helper(costs, 1, hs);
    }

    public int helper(int[] costs, int curr, HashSet<Integer> hs) {
        if (curr > 365)
            return 0;
        if (dp[curr] != -1)
            return dp[curr];
        int cost = (int) 1e9;
        if (!hs.contains(curr)) {
            return helper(costs, curr + 1, hs);
        } else {
            int one = costs[0] + helper(costs, curr + 1, hs);
            int two = costs[1] + helper(costs, curr + 7, hs);
            int three = costs[2] + helper(costs, curr + 30, hs);
            cost = Math.min(Math.min(cost, one), Math.min(two, three));
        }
        return dp[curr] = cost;
    }
}