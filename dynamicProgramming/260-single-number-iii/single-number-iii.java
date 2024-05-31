class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            if (checkbit(xor, i)) {
                bit = i;
                break;
            }
        }
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkbit(nums[i], bit))
                xor1 ^= nums[i];
            else
                xor2 ^= nums[i];
        }
        return new int[] { xor1, xor2 };
    }

    public boolean checkbit(int num, int i) {
        num = num >> i;
        if ((num & 1) == 1)
            return true;
        return false;
    }
}