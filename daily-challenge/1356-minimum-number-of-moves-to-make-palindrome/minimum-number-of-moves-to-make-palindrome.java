class Solution {
    public int minMovesToMakePalindrome(String s) {
        int ans = 0;
        while (s.length() > 0) {
            int i = s.indexOf(s.charAt(s.length() - 1));
            if (i == s.length() - 1) {
                ans += i / 2;
                s = s.substring(0, s.length() - 1);
            } else {
                ans += i;
                s = s.substring(0, i) + s.substring(i + 1, s.length() - 1);
            }
        }
        return ans;
    }
}