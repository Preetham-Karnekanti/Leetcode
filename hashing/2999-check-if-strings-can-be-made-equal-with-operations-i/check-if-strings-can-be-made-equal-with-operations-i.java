class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        return swapAndCheck(s1, s2) || swapAndCheck(s1, s2);
    }

    public boolean swapAndCheck(String s1, String s2) {
        char ch1[] = s1.toCharArray();
        swap(ch1, 0, 2);
        if (new String(ch1).equals(s2))
            return true;
        swap(ch1, 0, 2);
        swap(ch1, 1, 3);
        if (new String(ch1).equals(s2))
            return true;
        swap(ch1, 0, 2);
        if (new String(ch1).equals(s2))
            return true;
        return false;
    }

    public void swap(char ch[], int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}