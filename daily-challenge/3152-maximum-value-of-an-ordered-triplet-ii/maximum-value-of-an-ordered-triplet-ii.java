class Solution {
    public long maximumTripletValue(int[] nums) {
        long dmax = 0;
        long imax = 0;
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dmax * nums[i]);
            dmax = Math.max(dmax, imax - nums[i]);
            imax = Math.max(imax, nums[i]);
        }
        return ans;
    }
}