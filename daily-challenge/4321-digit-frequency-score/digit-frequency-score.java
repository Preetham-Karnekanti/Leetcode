class Solution {
    public int digitFrequencyScore(int n) {
        int freq[] = new int[10];
        while (n != 0) {
            int rem = n % 10;
            freq[rem]++;
            n /= 10;
        }
        int ans = 0;
        for (int i = 0; i < freq.length; i++) {
            ans += i * freq[i];
        }
        return ans;
    }
}