class Solution {
    int n;
    Boolean[][] memo;

    public boolean canCross(int[] stones) {
        n = stones.length;
        if (stones[1] != 1) {
            return false;
        }
        memo = new Boolean[2001][2001];
        return helper(1, 1, stones);
    }

    boolean helper(int idx, int prevUnit, int[] stones) {
        if (idx == n - 1) {
            return true;
        }
        if (memo[idx][prevUnit] != null) {
            return memo[idx][prevUnit];
        }
        boolean ans = false;
        for (int nextJump = prevUnit - 1; nextJump <= prevUnit + 1 && !ans; nextJump++) {
            if (nextJump > 0) {
                int nextStone = stones[idx] + nextJump;
                int nextIdx = Arrays.binarySearch(stones, idx, stones.length, nextStone);
                if (nextIdx > -1) {
                    ans = ans || helper(nextIdx, nextJump, stones);
                }
            }
        }
        return memo[idx][prevUnit] = ans;
    }
}