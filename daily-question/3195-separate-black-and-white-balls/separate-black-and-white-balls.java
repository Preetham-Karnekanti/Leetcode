class Solution {
    public long minimumSteps(String s) {
        int i = 0;
        int j = s.length() - 1;
        char ch[] = s.toCharArray();
        long res = 0;
        // while (i < j) {
        // while (i < j && s.charAt(j) == '1')
        // j--;
        // while (i < j && s.charAt(i) == '0')
        // i++;
        // res += j - i;
        // i++;
        // j--;
        // }
        // return res;
        while (i < j) {
            if (ch[i] == '1' && ch[j] == '0') {
                res += j - i;
                i++;
                j--;
            } else if (ch[i] == '0')
                i++;
            else
                j--;
        }
        return res;
    }
}