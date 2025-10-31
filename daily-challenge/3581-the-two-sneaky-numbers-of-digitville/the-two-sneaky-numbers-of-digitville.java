class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 ^= nums[i];
        }
        for (int i = 0; i < n; i++) {
            xor2 ^= i;
        }
        int xor = xor1 ^ xor2;
        int bit = findBit(xor);
        xor1 = xor2 = 0;
        for (int i : nums) {
            if (((i >> bit) & 1) == 1)
                xor1 ^= i;
            else
                xor2 ^= i;
        }

        for (int i = 0; i < n; i++) {
            if (((i >> bit) & 1) == 1)
                xor1 ^= i;
            else
                xor2 ^= i;
        }
        return new int[] { xor1, xor2 };
    }

    public int findBit(int num) {
        for (int i = 0; i < 32; i++) {
            int bit = ((num >> i) & 1);
            if (bit == 1)
                return i;
        }
        return -1;
    }
}