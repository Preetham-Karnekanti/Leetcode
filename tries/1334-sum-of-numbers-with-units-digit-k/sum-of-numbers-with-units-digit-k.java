class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0)
            return 0;
        ArrayList<Integer> al = new ArrayList<>();
        while (k <= num) {
            if (k != 0)
                al.add(k);
            k += 10;
        }
        int dp[][] = new int[num + 1][al.size()];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int ans = helper(al, num, 0, dp);
        return ans >= (int) 1e9 ? -1 : ans;
    }

    public int helper(ArrayList<Integer> al, int target, int idx, int[][] dp) {
        if (target == 0)
            return 0;
        if (idx >= al.size())
            return (int) 1e9;
        if (dp[target][idx] != -1)
            return dp[target][idx];
        int skip = helper(al, target, idx + 1, dp);
        int take = (int) 1e9;
        if (target >= al.get(idx))
            take = 1 + helper(al, target - al.get(idx), idx, dp);
        return dp[target][idx] = Math.min(take, skip);
    }
}