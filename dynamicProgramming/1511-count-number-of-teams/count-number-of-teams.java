class Solution {
    Integer dp1[][][];
    Integer dp2[][][];

    public int numTeams(int[] rating) {
        dp1 = new Integer[rating.length][rating.length + 1][4];
        dp2 = new Integer[rating.length][rating.length + 1][4];

        return helper(rating, 0, -1, 3) + helper1(rating, 0, -1, 3);
    }

    public int helper(int[] rating, int idx, int prev, int count) {
        if (count == 0) {
            return 1;
        }
        if (idx == rating.length)
            return 0;
        if (dp1[idx][prev + 1][count] != null)
            return dp1[idx][prev + 1][count];
        int notTake = helper(rating, idx + 1, prev, count);
        int take = 0;
        if (prev == -1 || rating[idx] > rating[prev]) {
            take = helper(rating, idx + 1, idx, count - 1);
        }
        return dp1[idx][prev + 1][count] = take + notTake;
    }

    public int helper1(int[] rating, int idx, int prev, int count) {
        if (count == 0) {
            return 1;
        }
        if (idx == rating.length)
            return 0;
        if (dp2[idx][prev + 1][count] != null)
            return dp2[idx][prev + 1][count];
        int notTake = helper1(rating, idx + 1, prev, count);
        int take = 0;
        if (prev == -1 || rating[idx] < rating[prev]) {
            take = helper1(rating, idx + 1, idx, count - 1);
        }
        return dp2[idx][prev + 1][count] = take + notTake;
    }
}