class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            int curAns = helper(tops, bottoms, i);
            ans = Math.min(ans, curAns);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int tops[], int bottoms[], int val) {
        int top = 0;
        int bottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val && bottoms[i] != val)
                return Integer.MAX_VALUE;
            else if (tops[i] != val)
                top++;
            else if (bottoms[i] != val)
                bottom++;
        }
        return Math.min(top, bottom);
    }
}