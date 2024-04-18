class Solution {
    public String removeStars(String s) {
        int n = s.length();
        char ch[] = new char[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                len--;
            else {
                ch[len++] = s.charAt(i);
            }
        }
        return String.valueOf(ch, 0, len);
    }
}