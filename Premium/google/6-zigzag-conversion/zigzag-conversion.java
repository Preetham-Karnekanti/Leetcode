class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int idx = 0;
        char arr[][] = new char[numRows][s.length()];
        int r = 0;
        int c = 0;
        for (char[] ch : arr)
            Arrays.fill(ch, ' ');
        while (idx < s.length()) {
            while (r < numRows && idx < s.length()) {
                arr[r][c] = s.charAt(idx++);
                r++;
            }
            r -= 2;
            c++;
            while (r >= 0 && idx < s.length()) {
                arr[r][c] = s.charAt(idx++);
                r--;
                c++;
            }
            r = 1;
            c--;
        }
        String ans = "";
        for (char[] ch : arr) {
            String temp = "";
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == ' ')
                    continue;
                else
                    temp += ch[i];
            }
            ans += temp.strip();
        }
        return ans;
    }
}