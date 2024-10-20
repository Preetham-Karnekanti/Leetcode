class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch != ')')
                st.push(ch);
            else if (ch == ')') {
                ArrayList<Character> temp = new ArrayList<>();
                while (st.peek() != '(')
                    temp.add(st.pop());
                st.pop();
                char op = st.pop();
                if (op == '!') {
                    st.push(temp.get(0) == 'f' ? 't' : 'f');
                } else if (op == '&') {
                    char result = 't';
                    for (char c : temp) {
                        if (c == 'f') {
                            result = 'f';
                            break;
                        }
                    }
                    st.push(result);
                } else if (op == '|') {
                    char result = 'f';
                    for (char c : temp) {
                        if (c == 't') {
                            result = 't';
                            break;
                        }
                    }
                    st.push(result);
                }
            }
        }
        return st.peek() == 't';
    }
}