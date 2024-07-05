class Solution {
    int n;
    Boolean[][] memo;

    public boolean canCross(int[] stones) {
        n = stones.length;
        if (stones[1] != 1) {
            return false;
        }
        memo = new Boolean[2001][2001];
        return helper(stones, 1, 1);
    }

    public boolean helper(int nums[], int idx, int prevJump) {
        if (idx == nums.length - 1)
            return true;
        if (memo[idx][prevJump] != null)
            return memo[idx][prevJump];
        boolean ans = false;
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1 && ans == false; nextJump++) {
            if (nextJump <= 0)
                continue;
            int nextStone = nums[idx] + nextJump;
            int newIdx = Arrays.binarySearch(nums, idx, nums.length, nextStone);
            if (newIdx >= 0)
                ans = ans || helper(nums, newIdx, nextJump);
        }
        return memo[idx][prevJump] = ans;
    }
}