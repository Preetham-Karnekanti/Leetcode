class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch != ')')
                st.push(ch);
            else if (ch == ')') {
                boolean hasTrue = false, hasFalse = false;
                while (st.peek() != '(') {
                    if (st.peek() == 'f')
                        hasFalse = true;
                    if (st.peek() == 't')
                        hasTrue = true;
                    st.pop();
                }
                st.pop();
                char op = st.pop();
                boolean result;
                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else {
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return st.peek() == 't';
    }
}