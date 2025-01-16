class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n % 2 == 0 && m % 2 == 0)
            return 0;
        int xor1 = 0;
        for (int i = 0; i < n; i++)
            xor1 ^= nums1[i];
        int xor2 = 0;
        for (int i = 0; i < m; i++)
            xor2 ^= nums2[i];
        if (n % 2 == 1 && m % 2 == 1)
            return xor1 ^ xor2;
        else if (n % 2 == 0)
            return xor1;
        return xor2;
    }
}
/**
 * 1 -[1,2,3]
 * 2-
 */