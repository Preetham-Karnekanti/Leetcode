class Solution {
    public int findGCD(int[] nums) {
        int min, max;
        min = max = nums[0];
        for (int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return findGcd(max, min);
    }

    public int findGcd(int a, int b) {
        if (b == 0)
            return a;
        if (a == 0)
            return b;
        return findGcd(b, a % b);
    }
}