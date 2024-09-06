class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int dp[][] = new int[n][4];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(obstacles, 0, 2, dp);
    }

    public int helper(int nums[], int idx, int lane, int dp[][]) {
        if (idx == nums.length - 1)
            return 0;
        if (dp[idx][lane] != -1)
            return dp[idx][lane];
        int min = (int) 1e9;
        if (nums[idx + 1] != lane) {
            return dp[idx][lane] = helper(nums, idx + 1, lane, dp);
        } else {
            int otherLanes[] = getOtherLanes(lane);
            int one = (int) 1e9;
            int two = (int) 1e9;
            if (nums[idx] != otherLanes[0])
                one = 1 + helper(nums, idx + 1, otherLanes[0], dp);
            if (nums[idx] != otherLanes[1])
                two = 1 + helper(nums, idx + 1, otherLanes[1], dp);
            return dp[idx][lane] = Math.min(one, two);
        }
    }

    public int[] getOtherLanes(int lane) {
        if (lane == 2)
            return new int[] { 1, 3 };
        if (lane == 1)
            return new int[] { 2, 3 };
        return new int[] { 1, 2 };
    }
}