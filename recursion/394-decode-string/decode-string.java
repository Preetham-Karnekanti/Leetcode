class Solution {
    public String decodeString(String s) {
        return solve(s, 0);
    }

    public String solve(String s, int idx) {
        if (idx >= s.length())
            return s;
        if (s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z')
            return solve(s, idx + 1);
        String num = "";
        String prev = s.substring(0, idx);
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9')
            num += s.charAt(idx++);
        int closingIdx = 0;
        if (s.charAt(idx) == '[') {
            closingIdx = findRespectiveClosing(s, idx);
        }
        String temp = prev + s.substring(idx + 1, closingIdx);
        for (int i = 1; i < Integer.parseInt(num); i++) {
            temp += s.substring(idx + 1, closingIdx);
        }
        temp += s.substring(closingIdx + 1);
        return solve(temp, 0);
    }

    public int findRespectiveClosing(String s, int idx) {
        Stack<Character> st = new Stack<>();
        for (int i = idx + 1; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                st.push('[');
            else if (s.charAt(i) == ']' && st.size() > 0) {
                st.pop();
            } else if (s.charAt(i) == ']' && st.size() == 0)
                return i;
        }
        return -1;
    }
}