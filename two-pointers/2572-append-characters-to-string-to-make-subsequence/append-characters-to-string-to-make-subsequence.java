class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = t.length();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        while (i < n && j < m) {
            if (sc[i] == tc[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return m - j;
    }
}