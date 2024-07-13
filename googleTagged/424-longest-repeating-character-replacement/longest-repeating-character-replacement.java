class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int freq[] = new int[26];
        int maxCount = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(i) - 'A']);
            if (i - l + 1 - maxCount > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}