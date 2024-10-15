class Solution {
    public long minimumSteps(String s) {
        int i = 0;
        int j = s.length() - 1;
        char ch[] = s.toCharArray();
        long res = 0;
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