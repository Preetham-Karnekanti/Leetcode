class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        return helper(students, mentors, 0, 0);
    }

    public int helper(int[][] students, int[][] mentors, int idx, int mask) {
        if (idx == students.length)
            return 0;
        int maxScore = 0;
        for (int i = 0; i < mentors.length; i++) {
            if (checkbit(mask, i) == false) {
                int newMask = mask | (1 << i);
                maxScore = Math.max(maxScore,
                        getScore(students[idx], mentors[i]) + helper(students, mentors, idx + 1, newMask));
            }
        }
        return maxScore;
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