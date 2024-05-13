class Solution {
    public int matrixSum(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int count = 0;
        for (int i = nums[0].length - 1; i >= 0; i--) {
            count += findMax(nums, i);
        }
        return count;
    }

    public int findMax(int[][] nums, int col) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][col] > max)
                max = nums[i][col];
        }
        return max;
    }
}