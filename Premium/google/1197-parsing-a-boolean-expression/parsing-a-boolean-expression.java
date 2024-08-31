class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == 't' || ch == 'f' || ch == '!' || ch == '|' || ch == '&' || ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                ArrayList<Character> temp = new ArrayList<>();
                while (st.peek() != '(') {
                    temp.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                if (op == '!') {
                    char result = temp.get(0) == 't' ? 'f' : 't';
                    st.push(result);
                } else if (op == '|') {
                    boolean result = false;
                    for (char c : temp) {
                        if (c == 't') {
                            result = true;
                            break;
                        }
                    }
                    st.push(result ? 't' : 'f');
                } else if (op == '&') {
                    boolean result = true;
                    for (char c : temp) {
                        if (c == 'f') {
                            result = false;
                            break;
                        }
                    }
                    st.push(result ? 't' : 'f');
                }
            }
        }

        return st.peek() == 't';
    }
}