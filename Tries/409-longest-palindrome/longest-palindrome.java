class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                ans += 2;
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (hs.size() > 0)
            ans++;
        return ans;
    }
}