class Solution {
    Integer dp[];

    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        int alicePoints = helper(stoneValue, 0);
        int totalSum = 0;
        for (int i : stoneValue)
            totalSum += i;
        int bobPoints = totalSum - alicePoints;
        if (alicePoints > bobPoints)
            return "Alice";
        if (bobPoints > alicePoints)
            return "Bob";
        return "Tie";
    }

    public int helper(int[] stones, int idx) {
        if (idx >= stones.length)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        int one, two, three;
        one = two = three = -(int) 1e9;
        one = stones[idx] + Math.min(
                Math.min(helper(stones, idx + 2), helper(stones, idx + 4)),
                helper(stones, idx + 3));
        if (idx + 1 < stones.length)
            two = stones[idx] + stones[idx + 1] + Math.min(
                    helper(stones, idx + 3),
                    Math.min(helper(stones, idx + 4), helper(stones, idx + 5)));
        if (idx + 2 < stones.length)
            three = stones[idx] + stones[idx + 1] + stones[idx + 2] + Math.min(
                    helper(stones, idx + 4),
                    Math.min(helper(stones, idx + 5), helper(stones, idx + 6)));
        return dp[idx] = Math.max(one, Math.max(two, three));
    }
}