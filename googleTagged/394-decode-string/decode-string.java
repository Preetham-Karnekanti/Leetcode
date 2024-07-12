class Solution {
    public String decodeString(String s) {
        return solve(s, 0);
    }

    public String solve(String s, int i) {
        if (i >= s.length() || s.indexOf('[') == -1)
            return s;
        if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            return solve(s, i + 1);
        String processedString = s.substring(0, i);
        String num = "";
        while (i < s.length() && s.charAt(i) != '[')
            num += s.charAt(i++);
        int closingIdx = 0;
        if (s.charAt(i) == '[') {
            closingIdx = findRespectiveClosingIndex(s, i);
        }
        for (int k = 0; k < Integer.parseInt(num); k++)
            processedString += s.substring(i + 1, closingIdx);
        processedString += s.substring(closingIdx + 1);
        return solve(processedString, 0);
    }

    public int findRespectiveClosingIndex(String s, int idx) {
        Stack<Character> st = new Stack<>();
        for (int i = idx + 1; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                st.push(s.charAt(i));
            else if (s.charAt(i) == ']' && st.size() > 0)
                st.pop();
            else if (s.charAt(i) == ']' && st.size() == 0)
                return i;
        }
        return -1;
    }
}