class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min_so_far = 0;
        int min_ending_here = 0;
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < nums.length; i++) {
            max_ending_here += nums[i];
            max_so_far = Math.max(max_so_far, max_ending_here);
            max_ending_here = Math.max(0, max_ending_here);

            min_ending_here += nums[i];
            min_so_far = Math.min(min_so_far, min_ending_here);
            min_ending_here = Math.min(0, min_ending_here);
        }

        return Math.max(max_so_far, Math.abs(min_so_far));
    }
}