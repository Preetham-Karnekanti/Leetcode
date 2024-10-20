class Solution {
    public int numberOfSubstrings(String s, int k) {
        int left = 0;
        int n = s.length();
        int ans = (n * (n + 1)) / 2;
        int freq[] = new int[26];
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            while (left <= right && freq[s.charAt(right) - 'a'] >= k) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            ans -= right - left + 1;
        }
        return ans;
    }
}