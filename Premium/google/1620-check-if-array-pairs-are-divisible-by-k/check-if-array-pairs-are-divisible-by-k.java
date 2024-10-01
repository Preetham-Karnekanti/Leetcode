class Solution {
    public boolean canArrange(int[] arr, int k) {
        int rem[] = new int[k];
        for (int i : arr) {
            int r = ((i % k) + k) % k;
            rem[r]++;
        }

        if (rem[0] % 2 != 0)
            return false;
        int i = 1;
        int j = k - 1;
        while (i < j) {
            if (rem[i++] != rem[j--])
                return false;
        }
        return true;
    }
}