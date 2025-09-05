class Solution {
    public int getLeastFrequentDigit(int n) {
        int freq[] = new int[10];
        while (n != 0) {
            freq[n % 10]++;
            n /= 10;
        }
        int min = Integer.MAX_VALUE;
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (freq[i] == 0)
                continue;
            if (freq[i] < min) {
                min = freq[i];
                val = i;
            }
        }
        return val;
    }
}