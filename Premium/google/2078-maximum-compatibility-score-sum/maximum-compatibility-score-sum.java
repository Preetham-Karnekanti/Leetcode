class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int dp[][] = new int[students.length][(1 << students.length)];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(students, mentors, 0, 0, dp);
    }

    public int helper(int[][] students, int[][] mentors, int idx, int mask, int[][] dp) {
        if (idx == students.length)
            return 0;
        if (dp[idx][mask] != -1)
            return dp[idx][mask];
        int maxScore = 0;
        for (int i = 0; i < mentors.length; i++) {
            if (checkbit(mask, i) == false) {
                int newMask = mask | (1 << i);
                maxScore = Math.max(maxScore,
                        getScore(students[idx], mentors[i]) + helper(students, mentors, idx + 1, newMask, dp));
            }
        }
        return dp[idx][mask] = maxScore;
    }

    public int getScore(int arr1[], int arr2[]) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i])
                count++;
        }
        return count;
    }

    public boolean checkbit(int num, int i) {
        num = num >> i;
        if ((num & 1) == 0)
            return false;
        return true;
    }
}