class Solution {
    public int minimumCost(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val < min) {
                secMin = min;
                min = val;
            } else if (val < secMin) {
                secMin = val;
            }
        }
        return nums[0] + min + secMin;
    }
}