class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (m > n)
            return false;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            char a = str1.charAt(i);
            char b = str2.charAt(j);
            if (a == b || a == 'z' && b == 'a' || a + 1 == b) {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }
}