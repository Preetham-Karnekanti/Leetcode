class Solution {
    public boolean canPermutePalindrome(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1)
                count++;
        }
        return count == 1 || count == 0;
    }
}