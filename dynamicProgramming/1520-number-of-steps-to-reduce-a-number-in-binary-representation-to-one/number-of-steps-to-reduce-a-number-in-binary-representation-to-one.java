class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (sb.length() > 1) {
            int idx = sb.length() - 1;
            int n = sb.length() - 1;
            char ch = sb.charAt(idx);
            if (ch == '0')
                sb.deleteCharAt(idx);
            else {
                while (n >= 0 && sb.charAt(n) == '1')
                    sb.setCharAt(n--, '0');
                if (n < 0)
                    sb.insert(0, '1');
                else
                    sb.setCharAt(n, '1');
            }
            count++;
        }
        return count;
    }
}