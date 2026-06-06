class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while (i < j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
            } else {
                if (isPallindrome(ch, i + 1, j))
                    return true;
                if (isPallindrome(ch, i, j - 1))
                    return true;
                return false;
            }
        }
        return j <= i;
    }

    public boolean isPallindrome(char[] ch, int i, int j) {
        while (i <= j) {
            if (ch[i] != ch[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}