class Solution {
    public int minimumSplits(int[] nums) {
        int gcd = 0;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            gcd = findGcd(gcd, nums[i]);
            if (gcd == 1) {
                gcd = nums[i];
                res++;
            }
        }
        return res;
    }

    public int findGcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return findGcd(b, a % b);
    }
}