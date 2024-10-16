class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int freq[] = new int[26];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            while (freq[s.charAt(right) - 'a'] >= 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            int len = right - left + 1;
            ans += len;
        }
        return ans;
    }
}