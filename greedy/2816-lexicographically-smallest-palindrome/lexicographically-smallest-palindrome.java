class Solution {
    public String makeSmallestPalindrome(String s) {
        char ch[] = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (ch[i] != ch[j]) {
                char one = ch[i];
                char two = ch[j];
                ch[i] = one > two ? two : one;
                ch[j] = one > two ? two : one;
            }
            i++;
            j--;
        }
        return new String(ch);
    }
}