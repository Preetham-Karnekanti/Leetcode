class Solution {
    public boolean consecutiveSetBits(int n) {
        int prev = -1;
        boolean isConsecutive = false;
        while (n != 0) {
            int bit = n & 1;
            if (prev == bit && bit == 1) {
                if (isConsecutive)
                    return false;
                isConsecutive = true;
            }
            prev = bit;
            n >>= 1;
        }
        return isConsecutive;
    }
}

// 1100