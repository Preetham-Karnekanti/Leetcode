class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(ch, i, j);
            i += k + k;
        }
        return new String(ch);
    }

    public void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}