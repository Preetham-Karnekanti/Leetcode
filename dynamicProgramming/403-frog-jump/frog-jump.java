class Solution {
    Boolean dp[][];

    public boolean canCross(int[] stones) {
        dp = new Boolean[stones.length][stones.length];
        return helper(stones, 0, 1);
    }

    public boolean helper(int stones[], int idx, int jump) {
        if (idx >= stones.length)
            return false;
        if (idx == stones.length - 1)
            return true;
        if (dp[idx][jump] != null)
            return dp[idx][jump];
        boolean res = false;
        
        if (idx == 0) {
            if (stones[idx + 1] - stones[idx] == 1)
                res = res | helper(stones, idx + 1, 1);
            return res;
        }
        for (int i = idx + 1; i < stones.length; i++) {
            if (stones[i] - stones[idx] > jump + 1)
                break;
            if (stones[i] - stones[idx] == jump - 1)
                res = res || helper(stones, i, jump - 1);
            if (stones[i] - stones[idx] == jump)
                res = res || helper(stones, i, jump);
            if (stones[i] - stones[idx] == jump + 1)
                res = res || helper(stones, i, jump + 1);
        }

        return dp[idx][jump] = res;
    }
}