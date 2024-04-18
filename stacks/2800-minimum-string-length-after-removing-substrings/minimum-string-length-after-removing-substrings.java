class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                if (!st.isEmpty() && st.peek() == 'A') {
                    st.pop();
                    continue;
                }
            } else if (s.charAt(i) == 'D') {
                if (!st.isEmpty() && st.peek() == 'C') {
                    st.pop();
                    continue;
                }
            }
            st.push(s.charAt(i));
        }
        return st.size();
    }
}