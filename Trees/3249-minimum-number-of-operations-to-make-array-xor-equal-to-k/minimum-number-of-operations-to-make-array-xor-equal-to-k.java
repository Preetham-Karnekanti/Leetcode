class Solution {
    public int minOperations(int[] nums, int k) {
        int res = k;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return countBits(res);
    }

    public int countBits(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(num, i))
                count++;
        }
        return count;
    }

    public boolean checkBit(int num, int i) {
        num >>= i;
        if ((num & 1) == 1)
            return true;
        return false;
    }
}