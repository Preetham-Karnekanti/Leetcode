class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                String temp = "";
                while (st.peek() != '(') {
                    temp += st.pop();
                }
                st.pop();
                for (int j = 0; j < temp.length(); j++) {
                    st.push(temp.charAt(j));
                }
            } else
                st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}