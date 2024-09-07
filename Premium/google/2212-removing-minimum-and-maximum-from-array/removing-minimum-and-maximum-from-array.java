class Solution {
    public int minimumDeletions(int[] nums) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sIndex = nums.length;
        int lIndex = -1;
        for (int i=0;i<nums.length;i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        for (int i=0;i<nums.length;i++) {
            if (nums[i] == max || nums[i] == min) {
                sIndex = Math.min(i, sIndex);
                lIndex = Math.max(i, lIndex);
            }
        }
        int v1 = lIndex + 1;
        int v2 = nums.length - sIndex;
        int v3 = (sIndex + 1) + (nums.length - lIndex);
        return Math.min(v1, Math.min(v2, v3));
    }
}