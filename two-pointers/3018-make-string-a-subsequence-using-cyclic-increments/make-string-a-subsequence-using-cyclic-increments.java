class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (m > n)
            return false;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            int k = str1.charAt(i) - 'a';
            k = (k + 1) % 26 + 'a';
            if (str1.charAt(i) == str2.charAt(j) || (char) k == str2.charAt(j))
                j++;
            i++;
        }
        return j == str2.length();
    }
}