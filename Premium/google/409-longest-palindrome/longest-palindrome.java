class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[256];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        boolean hasOdd = false;
        for (int i = 0; i < 256; i++) {
            if (freq[i] % 2 == 0)
                ans += freq[i];
            else {
                ans += freq[i] - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? ans + 1 : ans;
    }
}