class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                count++;
        }
        if (count == 0)
            return false;
        return true;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
}