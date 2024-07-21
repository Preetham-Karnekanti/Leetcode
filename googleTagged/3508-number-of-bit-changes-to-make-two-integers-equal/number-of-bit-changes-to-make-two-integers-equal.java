class Solution {
    public int minChanges(int n, int k) {
        int[] nBits = getBits(n);
        int[] kBits = getBits(k);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (nBits[i] == kBits[i])
                continue;
            if (nBits[i] == 1 && kBits[i] == 0)
                count++;
            else
                return -1;
        }
        return count;
    }

    public int[] getBits(int num) {
        int idx = 31;
        int bits[] = new int[32];
        while (num > 0) {
            bits[idx--] = num % 2;
            num /= 2;
        }
        return bits;
    }
}