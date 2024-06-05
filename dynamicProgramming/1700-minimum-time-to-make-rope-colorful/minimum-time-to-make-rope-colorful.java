class Solution {
    public String col;
    public int time[];
    Integer dp[][];

    public int minCost(String colors, int[] neededTime) {
        col = new String(colors);
        int size = col.length();
        long sum = 0;
        for (int t : neededTime)
            sum += t;
        time = neededTime;
        dp = new Integer[size][27];
        return (int) sum - getMinCost(0, -1);
    }

    public int getMinCost(int ind, int prev) {

        // base case
        if (ind == time.length) {
            return 0;
        }
        if (dp[ind][prev + 1] != null)
            return dp[ind][prev + 1];
        int notPick = 0 + getMinCost(ind + 1, prev);

        int pick = 0;

        if (prev != col.charAt(ind) - 'a' || prev == -1) {
            pick = time[ind] + getMinCost(ind + 1, col.charAt(ind) - 'a');
        }
        return dp[ind][prev + 1] = Math.max(pick, notPick);
    }
}