class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int dp[][] = new int[n+1][4];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        return helper(0, n - 1, obstacles, 2, dp);
    }

    public int helper(int idx, int target, int[] obstacles, int lane, int dp[][]) {
        if (idx == target)
            return 0;
        if(dp[idx][lane] != -1)
            return dp[idx][lane];
        if (obstacles[idx + 1] == lane) {
            int[] otherLanes = getOtherTwoLanes(lane);
            int one = (int) 1e9;
            int two = (int) 1e9;
            if (obstacles[idx] != otherLanes[0])
                one = helper(idx + 1, target, obstacles, otherLanes[0], dp);
            if (obstacles[idx] != otherLanes[1])
                two = helper(idx + 1, target, obstacles, otherLanes[1], dp);
            return dp[idx][lane] = Math.min(one, two) + 1;
        } else
            return dp[idx][lane] = helper(idx + 1, target, obstacles, lane, dp);
    }

    public int[] getOtherTwoLanes(int lane) {
        if (lane == 2)
            return new int[] { 1, 3 };
        if (lane == 1)
            return new int[] { 2, 3 };
        return new int[] { 1, 2 };
    }
}